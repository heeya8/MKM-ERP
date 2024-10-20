package com.mkm.erp.domain.bi.service;

import com.mkm.erp.domain.bi.dto.request.BOMRequest;
import com.mkm.erp.domain.bi.dto.response.BOMResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.entity.BOM;
import com.mkm.erp.domain.bi.entity.Material;
import com.mkm.erp.domain.bi.entity.Recipe;
import com.mkm.erp.domain.bi.exception.ResourceNotFoundException;
import com.mkm.erp.domain.bi.repository.BOMRepository;
import com.mkm.erp.domain.bi.repository.MaterialRepository;  // 추가된 부분
import com.mkm.erp.domain.bi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BOMService {
    private final BOMRepository bomRepository;
    private final ProductRepository productRepository;
    private final MaterialRepository materialRepository;  // 추가된 부분

    // BOM 목록 조회
    public ResponseDto<BOMResponse> getBOMs(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<BOM> bomPage = bomRepository.findAll(pageable);

        return new ResponseDto<>(
                bomPage.getContent().stream()
                        .map(this::mapToResponse)
                        .collect(Collectors.toList()),
                bomPage.getNumber() + 1,
                bomPage.getSize(),
                bomPage.getTotalElements(),
                bomPage.getTotalPages(),
                bomPage.isLast()
        );
    }

    // BOM 생성
    @Transactional
    public BOMResponse createBOM(BOMRequest bomRequest) {
        // Product 확인
        var product = productRepository.findById(bomRequest.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("모품목을 찾을 수 없습니다. ID: " + bomRequest.getProductId()));

        // BOM 생성
        BOM bom = new BOM(product);

        // 레시피 추가
        List<Recipe> recipes = bomRequest.getRecipes().stream()
                .map(recipeRequest -> {
                    // Material 조회
                    Material material = materialRepository.findByName(recipeRequest.getChildId())
                            .orElseThrow(() -> new ResourceNotFoundException("자재를 찾을 수 없습니다. 이름: " + recipeRequest.getChildId()));

                    // Recipe 생성
                    return new Recipe(bom, material, recipeRequest.getQuantity());
                })
                .collect(Collectors.toList());
        bom.setRecipes(recipes);

        // BOM 저장
        BOM savedBOM = bomRepository.save(bom);
        return mapToResponse(savedBOM);
    }

    // BOM 조회
    public BOMResponse getBOM(Long id) {
        BOM bom = bomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BOM을 찾을 수 없습니다. ID: " + id));
        return mapToResponse(bom);
    }

    // BOM 업데이트
    @Transactional
    public void updateBOM(Long id, BOMRequest bomRequest) {
        // 기존 BOM 조회
        BOM existingBOM = bomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BOM을 찾을 수 없습니다. ID: " + id));

        // 업데이트할 Product 확인
        var product = productRepository.findById(bomRequest.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("모품목을 찾을 수 없습니다. ID: " + bomRequest.getProductId()));

        // BOM 필드 업데이트
        existingBOM.setProduct(product);

        // 레시피 업데이트
        List<Recipe> recipes = bomRequest.getRecipes().stream()
                .map(recipeRequest -> {
                    // Material 조회
                    Material material = materialRepository.findById(recipeRequest.getChildId())
                            .orElseThrow(() -> new ResourceNotFoundException("자재를 찾을 수 없습니다. ID: " + recipeRequest.getChildId()));

                    // Recipe 생성
                    return new Recipe(existingBOM, material, recipeRequest.getQuantity());
                })
                .collect(Collectors.toList());

        // 기존 레시피를 모두 삭제하고 새 레시피로 교체
        existingBOM.getRecipes().clear();
        existingBOM.getRecipes().addAll(recipes);

        // BOM 저장
        bomRepository.save(existingBOM);
    }

    // BOM 삭제
    @Transactional
    public void deleteBOM(Long id) {
        if (!bomRepository.existsById(id)) {
            throw new ResourceNotFoundException("BOM을 찾을 수 없습니다. ID: " + id);
        }
        bomRepository.deleteById(id);
    }

    // BOMResponse로 변환하는 메서드
    private BOMResponse mapToResponse(BOM bom) {
        BOMResponse response = new BOMResponse();
        response.setId(bom.getId());
        response.setProductId(bom.getProduct().getId());
        response.setRecipes(bom.getRecipes().stream()
                .map(recipe -> {
                    BOMResponse.RecipeResponse recipeResponse = new BOMResponse.RecipeResponse();
                    recipeResponse.setId(recipe.getId());
                    recipeResponse.setChildId(recipe.getMaterial().getName());  // 수정된 부분: childId 대신 material의 name 사용
                    recipeResponse.setQuantity(recipe.getQuantity());
                    return recipeResponse;
                })
                .collect(Collectors.toList()));
        return response;
    }
}
