// ProductService.java
package com.mkm.erp.domain.bi.service;

import com.mkm.erp.domain.bi.dto.request.ProductRequest;
import com.mkm.erp.domain.bi.dto.response.ProductResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.entity.Product;
import com.mkm.erp.domain.bi.entity.Subcategory;
import com.mkm.erp.domain.bi.entity.UnitType;
import com.mkm.erp.domain.bi.exception.ResourceNotFoundException;
import com.mkm.erp.domain.bi.repository.ProductRepository;
import com.mkm.erp.domain.bi.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SubcategoryRepository subcategoryRepository;

    public ResponseDto<ProductResponse> getProducts(int page, int size, String sortBy, String unitType) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name"); // 기본 정렬을 이름순으로 설정

        // sortBy 값에 따른 정렬 방식 변경
        if ("recent".equals(sortBy)) {
            sort = Sort.by(Sort.Direction.DESC, "createdAt"); // 최신추가순
        } else if ("oldest".equals(sortBy)) {
            sort = Sort.by(Sort.Direction.ASC, "createdAt"); // 오래된 추가순
        } else if ("unit".equals(sortBy)) {                             // 단위별
            sort = Sort.by(Sort.Direction.ASC, "unit").and(Sort.by(Sort.Direction.ASC, "name")); // 유닛별, 이름순 정렬
        }

        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Product> productPage = productRepository.findAll(pageable);

        // 카테고리 및 유닛 필터링
        List<Product> filteredProducts = productPage.getContent().stream()
                .filter(product -> (unitType == null || product.getUnit().toString().equals(unitType))) // 유닛 필터
                .collect(Collectors.toList());

        return new ResponseDto<>(
                filteredProducts.stream() // 필터링된 리스트를 사용
                        .map(product -> new ProductResponse(
                                product.getItemCode(),
                                product.getName(),
                                "생산품",
                                product.getSubcategory().getName(),
                                product.getUnit().toString()
                        ))
                        .collect(Collectors.toList()),
                productPage.getNumber() + 1,
                productPage.getSize(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isLast()
        );
    }

    @Transactional
    public void createProduct(ProductRequest request) {
        Subcategory subcategory = subcategoryRepository.findByName(request.getSubcategoryName())
                .orElseThrow(() -> new ResourceNotFoundException("소분류를 찾을 수 없습니다. 이름: " + request.getSubcategoryName()));

        // 가장 큰 품목코드 가져오기
        String maxCode = productRepository.findMaxItemCode();
        String nextCode = generateNextItemCode("P", maxCode);

        Product product = new Product(request);
        product.setSubcategory(subcategory);
        product.setItemCode(nextCode);  // 품목코드 설정
        productRepository.save(product);
    }

    private String generateNextItemCode(String prefix, String maxCode) {
        if (maxCode == null) {
            // 첫 번째 품목인 경우 P0001부터 시작
            return prefix + "0001";
        }
        // 마지막 숫자 부분 추출 후 1을 더한 값으로 새 코드 생성
        int nextNumber = Integer.parseInt(maxCode.substring(1)) + 1;
        return prefix + String.format("%04d", nextNumber);
    }


    @Transactional
    public void updateProduct(Long id, ProductRequest request) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(request.getName());
            product.setQuantity(request.getQuantity());
            product.setUnit(UnitType.valueOf(request.getUnit()));

            // 소분류 이름으로 소분류 찾기
            Subcategory subcategory = subcategoryRepository.findByName(request.getSubcategoryName())
                    .orElseThrow(() -> new ResourceNotFoundException("소분류를 찾을 수 없습니다. 이름: " + request.getSubcategoryName()));
            product.setSubcategory(subcategory);  // 소분류 업데이트

            productRepository.save(product);
        } else {
            throw new ResourceNotFoundException("상품을 찾을 수 없습니다. ID: " + id);
        }
    }

    @Transactional
    public void deleteProduct(Long id) {
        if (productRepository.existsById(String.valueOf(id))) {
            productRepository.deleteById(String.valueOf(id));
        } else {
            throw new ResourceNotFoundException("상품을 찾을 수 없습니다. ID: " + id);
        }
    }
}
