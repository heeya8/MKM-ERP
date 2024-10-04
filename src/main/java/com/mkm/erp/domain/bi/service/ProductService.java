package com.mkm.erp.domain.bi.service;

import com.mkm.erp.domain.bi.dto.request.ProductRequest;
import com.mkm.erp.domain.bi.dto.response.ProductResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.entity.Product;
import com.mkm.erp.domain.bi.exception.ResourceNotFoundException;
import com.mkm.erp.domain.bi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ResponseDto<ProductResponse> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size); // 페이지 인덱스는 0부터 시작하므로 -1
        Page<Product> productPage = productRepository.findAll(pageable);

        return new ResponseDto<>(
                productPage.getContent().stream()
                        .map(product -> new ProductResponse(
                                product.getId(),
                                product.getName(),
                                product.getQuantity(),
                                product.getUnit().toString()
                        ))
                        .collect(Collectors.toList()),  // content 변환
                productPage.getNumber() + 1,          // 현재 페이지 번호 (0-based에서 1-based로)
                productPage.getSize(),                // 페이지 크기
                productPage.getTotalElements(),       // 전체 요소 수
                productPage.getTotalPages(),          // 전체 페이지 수
                productPage.isLast()                  // 마지막 페이지 여부
        );
    }

    @Transactional
    public void createProduct(ProductRequest request) {
        Product product = new Product(request);
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(Long id, ProductRequest request) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(request.getName());
            product.setQuantity(request.getQuantity());
            product.setUnit(Product.UnitType.valueOf(request.getUnit()));

            productRepository.save(product);
        } else {
            throw new ResourceNotFoundException("상품을 찾을 수 없습니다. ID: " + id);
        }
    }

    @Transactional
    public void deleteProduct(Long id) {
        // 기존 상품이 존재하는지 확인 후 삭제
        if (productRepository.existsById(String.valueOf(id))) {
            productRepository.deleteById(String.valueOf(id));
        } else {
            throw new ResourceNotFoundException("상품을 찾을 수 없습니다. ID: " + id);
        }
    }
}
