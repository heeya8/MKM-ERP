package com.mkm.erp.domain.bi.controller;

import com.mkm.erp.domain.bi.dto.request.ProductRequest;
import com.mkm.erp.domain.bi.dto.response.ProductResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.service.ProductService;
import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/information")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<ResponseDto<ProductResponse>> getProducts(
            @Auth AuthUser authUser,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(productService.getProducts(page, size));
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@Auth AuthUser authUser, @RequestBody ProductRequest request) {
        productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("상품이 생성되었습니다.");
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<Void> updateProduct(@Auth AuthUser authUser, @PathVariable Long id, @RequestBody ProductRequest request) {
        productService.updateProduct(id, request);
        return ResponseEntity.ok().build(); // 200 OK 반환
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@Auth AuthUser authUser, @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
