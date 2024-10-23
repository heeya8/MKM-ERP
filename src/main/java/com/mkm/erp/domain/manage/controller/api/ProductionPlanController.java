package com.mkm.erp.domain.manage.controller;

import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.repository.ProductRepository;
import com.mkm.erp.domain.bi.service.ProductService;
import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import com.mkm.erp.domain.manage.dto.request.ProductionPlanRequest;
import com.mkm.erp.domain.manage.dto.response.MaterialRequirementResponse;
import com.mkm.erp.domain.manage.dto.response.ProductionPlanResponse;
import com.mkm.erp.domain.manage.service.ProductionPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mkm.erp.domain.bi.entity.Product;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("api/manage/work")
@RequiredArgsConstructor
public class ProductionPlanController {

    private final ProductionPlanService productionPlanService;
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/plan")
    public ResponseEntity<ResponseDto<ProductionPlanResponse>> getAllProductionPlans(
            @Auth AuthUser authUser,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String productName) {
        return ResponseEntity.ok(productionPlanService.getAllProductionPlans(page, size, sortBy, productName));
    }

    @GetMapping("/plan/{id}")
    public ResponseEntity<ProductionPlanResponse> getProductionPlan(@PathVariable Long id) {
        return ResponseEntity.ok(productionPlanService.getProductionPlan(id));
    }

    @PostMapping("/plan")
    public ResponseEntity<String> createProductionPlan(@Auth AuthUser authUser, @RequestBody ProductionPlanRequest request) {
        productionPlanService.createProductionPlan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("계획이 등록되었습니다.");
    }

    @PatchMapping("/plan/{id}")
    public ResponseEntity<Void> updateProductionPlan(@Auth AuthUser authUser, @PathVariable Long id, @RequestBody ProductionPlanRequest request) {
        productionPlanService.updateProductionPlan(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/plan/{id}")
    public ResponseEntity<Void> deleteProductionPlan(@Auth AuthUser authUser, @PathVariable Long id) {
        productionPlanService.deleteProductionPlan(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mrp")
    public ResponseEntity<MaterialRequirementResponse> calculateMaterials(
            @RequestParam String productName,
            @RequestParam int productionQuantity) {

        MaterialRequirementResponse response = productionPlanService.calculateMaterialRequirement(productName, productionQuantity);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/productId")
    public ResponseEntity<Map<String, Long>> getProductIdByName(@RequestParam String productName) {
        Long productId = productRepository.findByName(productName)
                .map(Product::getId) // Optional에서 ID를 추출
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 제품 이름: " + productName)); // 이름이 없을 경우 예외 처리
        return ResponseEntity.ok(Collections.singletonMap("id", productId)); // { id: <productId> } 형태로 응답
    }
}