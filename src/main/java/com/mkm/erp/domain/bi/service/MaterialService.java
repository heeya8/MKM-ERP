package com.mkm.erp.domain.bi.service;

import com.mkm.erp.domain.bi.dto.request.MaterialRequest;
import com.mkm.erp.domain.bi.dto.response.MaterialResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.entity.Material;
import com.mkm.erp.domain.bi.entity.Product;
import com.mkm.erp.domain.bi.entity.Subcategory;
import com.mkm.erp.domain.bi.exception.ResourceNotFoundException;
import com.mkm.erp.domain.bi.repository.MaterialRepository;
import com.mkm.erp.domain.bi.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final SubcategoryRepository subcategoryRepository;

    // 원자재 CRUD - 페이징 처리된 원자재 목록을 반환
    public ResponseDto<MaterialResponse> getMaterials(int page, int size, String sortBy, String unitType) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name"); // 기본 정렬을 이름순으로 설정

        // sortBy 값에 따른 정렬 방식 변경
        if ("recent".equals(sortBy)) {
            sort = Sort.by(Sort.Direction.DESC, "createdAt"); // 최신추가순
        } else if ("oldest".equals(sortBy)) {
            sort = Sort.by(Sort.Direction.ASC, "createdAt"); // 오래된 추가순
        } else if ("unit".equals(sortBy)) {
            sort = Sort.by(Sort.Direction.ASC, "unit").and(Sort.by(Sort.Direction.ASC, "name")); // 유닛별, 이름순 정렬
        }

        Pageable pageable = PageRequest.of(page - 1, size, sort); // 페이지 인덱스는 0부터 시작하므로 -1
        Page<Material> materialsPage = materialRepository.findAll(pageable);

        // 카테고리 및 유닛 필터링
        List<Material> filteredMaterials = materialsPage.getContent().stream()
                .filter(material -> (unitType == null || material.getUnit().toString().equals(unitType))) // 유닛 필터
                .collect(Collectors.toList());

        return new ResponseDto<>(
                filteredMaterials.stream()
                        .map(material -> new MaterialResponse(
                                material.getId(),
                                material.getItemCode(),
                                material.getName(),
                                material.getQuantity(),
                                material.getUnit().toString(),
                                material.getSubcategory().getName()  // 소분류 이름 반환
                        ))
                        .collect(Collectors.toList()),  // content 변환
                materialsPage.getNumber() + 1,          // 현재 페이지 번호 (0-based에서 1-based로)
                materialsPage.getSize(),                // 페이지 크기
                materialsPage.getTotalElements(),       // 전체 요소 수
                materialsPage.getTotalPages(),          // 전체 페이지 수
                materialsPage.isLast()                  // 마지막 페이지 여부
        );
    }

    @Transactional
    public void createMaterial(MaterialRequest request) {
        Subcategory subcategory = subcategoryRepository.findByName(request.getSubcategoryName())
                .orElseThrow(() -> new ResourceNotFoundException("소분류를 찾을 수 없습니다. 이름: " + request.getSubcategoryName()));

        // 가장 큰 품목코드 가져오기
        String maxCode = materialRepository.findMaxItemCode();
        String nextCode = generateNextItemCode("M", maxCode);

        Material material = new Material(request, subcategory);
        material.setItemCode(nextCode);  // 품목코드 설정
        materialRepository.save(material);
    }

    private String generateNextItemCode(String prefix, String maxCode) {
        if (maxCode == null) {
            // 첫 번째 품목인 경우 M0001부터 시작
            return prefix + "0001";
        }
        // 마지막 숫자 부분 추출 후 1을 더한 값으로 새 코드 생성
        int nextNumber = Integer.parseInt(maxCode.substring(1)) + 1;
        return prefix + String.format("%04d", nextNumber);
    }



    @Transactional
    public void updateMaterial(Long id, MaterialRequest request) {
        Optional<Material> existingMaterial = materialRepository.findById(id);
        if (existingMaterial.isPresent()) {
            Material material = existingMaterial.get();
            material.setName(request.getName());
            material.setQuantity(request.getQuantity());
            material.setUnit(Material.UnitType.valueOf(request.getUnit()));

            // 소분류 이름을 통해 소분류 엔티티 조회 후 업데이트
            Subcategory subcategory = subcategoryRepository.findByName(request.getSubcategoryName())
                    .orElseThrow(() -> new ResourceNotFoundException("소분류를 찾을 수 없습니다. 이름: " + request.getSubcategoryName()));
            material.setSubcategory(subcategory);

            materialRepository.save(material);
        } else {
            throw new ResourceNotFoundException("자재를 찾을 수 없습니다. ID: " + id);
        }
    }

    @Transactional
    public void deleteMaterial(Long id) {
        // 기존 자재가 존재하는지 확인 후 삭제
        if (materialRepository.existsById(String.valueOf(id))) {
            materialRepository.deleteById(String.valueOf(id));
        } else {
            throw new ResourceNotFoundException("자재를 찾을 수 없습니다. ID: " + id);
        }
    }
}
