package com.mkm.erp.domain.manage.service;

import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.entity.BOM;
import com.mkm.erp.domain.bi.entity.Material;
import com.mkm.erp.domain.bi.entity.Product;
import com.mkm.erp.domain.bi.entity.Recipe;
import com.mkm.erp.domain.bi.repository.BOMRepository;
import com.mkm.erp.domain.bi.repository.MaterialRepository;
import com.mkm.erp.domain.bi.repository.ProductRepository;
import com.mkm.erp.domain.manage.dto.request.ProductionPlanRequest;
import com.mkm.erp.domain.manage.dto.request.PurchaseOrderRequest;
import com.mkm.erp.domain.manage.dto.response.MaterialRequirementResponse;
import com.mkm.erp.domain.manage.dto.response.ProductionPlanResponse;
import com.mkm.erp.domain.manage.entity.MaterialRequirement;
import com.mkm.erp.domain.manage.entity.ProductionPlan;
import com.mkm.erp.domain.manage.repository.ProductionPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductionPlanService {

    private final ProductionPlanRepository productionPlanRepository;
    private final ProductRepository productRepository;
    private final BOMRepository bomRepository; // BOM 조회를 위한 Repository 추가
    private final MaterialRepository materialRepository;
    private final PurchaseOrderService purchaseOrderService;

    @Transactional
    public ProductionPlanResponse createProductionPlan(ProductionPlanRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + request.getProductId()));

        ProductionPlan productionPlan = new ProductionPlan();
        productionPlan.setProduct(product);
        productionPlan.setQuantity(request.getQuantity());
        productionPlan.setStart(request.getStart());
        productionPlan.setFinish(request.getFinish());

        ProductionPlan savedProductionPlan = productionPlanRepository.save(productionPlan);

        return mapToResponse(savedProductionPlan);
    }

    @Transactional(readOnly = true)
    public ProductionPlanResponse getProductionPlan(Long id) {
        ProductionPlan productionPlan = productionPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Production plan not found. ID: " + id));
        return mapToResponse(productionPlan);
    }

    @Transactional(readOnly = true)
    public ResponseDto<ProductionPlanResponse> getAllProductionPlans(int page, int size, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id"); // 기본 정렬

        if ("recent".equals(sortBy)) {  // 생성 최신순
            sort = Sort.by(Sort.Direction.DESC, "createdAt");
        } else if ("oldest".equals(sortBy)) {   // 생성 오래된순
            sort = Sort.by(Sort.Direction.ASC, "createdAt");
        } else if ("startAsc".equals(sortBy)) { // 생산시작일 빠른순
            sort = Sort.by(Sort.Direction.ASC, "start");
        } else if ("startDesc".equals(sortBy)) { // 생산시작일 늦은순
            sort = Sort.by(Sort.Direction.DESC, "start");
        } else if ("finishAsc".equals(sortBy)) { // 생산마감일 빠른순
            sort = Sort.by(Sort.Direction.ASC, "finish");
        } else if ("finishDesc".equals(sortBy)) { // 생산마감일 늦은순
            sort = Sort.by(Sort.Direction.DESC, "finish");
        } else if ("quantityAsc".equals(sortBy)) { // 수량 적은순
            sort = Sort.by(Sort.Direction.ASC, "quantity");
        } else if ("quantityDesc".equals(sortBy)) { // 수량 많은순
            sort = Sort.by(Sort.Direction.DESC, "quantity");
        }

        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<ProductionPlan> productionPlanPage = productionPlanRepository.findAll(pageable);

        return new ResponseDto<>(
                productionPlanPage.getContent().stream()
                        .map(this::mapToResponse)
                        .collect(Collectors.toList()),
                productionPlanPage.getNumber() + 1,
                productionPlanPage.getSize(),
                productionPlanPage.getTotalElements(),
                productionPlanPage.getTotalPages(),
                productionPlanPage.isLast()
        );
    }


    @Transactional
    public ProductionPlanResponse updateProductionPlan(Long id, ProductionPlanRequest request) {
        ProductionPlan productionPlan = productionPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Production plan not found. ID: " + id));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + request.getProductId()));

        productionPlan.setProduct(product);
        productionPlan.setQuantity(request.getQuantity());
        productionPlan.setStart(request.getStart());
        productionPlan.setFinish(request.getFinish());

        ProductionPlan updatedProductionPlan = productionPlanRepository.save(productionPlan);

        return mapToResponse(updatedProductionPlan);
    }

    @Transactional
    public void deleteProductionPlan(Long id) {
        productionPlanRepository.deleteById(id);
    }

    private ProductionPlanResponse mapToResponse(ProductionPlan productionPlan) {
        return new ProductionPlanResponse(
                productionPlan.getId(),
                productionPlan.getProduct().getName(),
                productionPlan.getQuantity(),
                productionPlan.getStart(),
                productionPlan.getFinish(),
                productionPlan.getCreatedAt()
        );
    }

    // 생산 계획 생성 및 자재 소요량 계산
    @Transactional
    public MaterialRequirementResponse calculateMaterialRequirement(Long productId, int productionQuantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + productId));

        BOM bom = bomRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalArgumentException("BOM not found for product ID: " + productId));

        // 자재 소요량 계산
        List<MaterialRequirement> materialRequirements = new ArrayList<>();
        List<MaterialRequirement> shortages = new ArrayList<>(); // 부족한 자재 목록

        for (Recipe recipe : bom.getRecipes()) {
            int requiredQuantity = recipe.getQuantity() * productionQuantity;
            int availableQuantity = getAvailableMaterialQuantity(recipe.getMaterial().getId());
            int shortageQuantity = requiredQuantity - availableQuantity;

            materialRequirements.add(new MaterialRequirement(recipe.getMaterial().getName(), requiredQuantity));

            // 부족한 경우, 부족한 수량 + 10을 추가
            if (shortageQuantity > 0) {
                shortages.add(new MaterialRequirement(recipe.getMaterial().getName(), shortageQuantity + 10));
            }
        }

        // 부족한 자재 자동 발주
        if (!shortages.isEmpty()) {
            createPurchaseOrders(shortages);
        }

        return new MaterialRequirementResponse(materialRequirements, shortages);
    }

    private int getAvailableMaterialQuantity(Long materialId) {
        // 원자재의 현재 재고 수량을 반환하는 메소드 (예시로 조회)
        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid material ID: " + materialId));
        return material.getQuantity();
    }

    private void createPurchaseOrders(List<MaterialRequirement> shortages) {
        for (MaterialRequirement shortage : shortages) {
            PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
            orderRequest.setMaterialName(shortage.getMaterialId());
            orderRequest.setOrderQuantity(shortage.getRequiredQuantity());

            // PurchaseOrderService를 통해 발주 요청 생성
            purchaseOrderService.createPurchaseOrder(orderRequest);
        }
    }
}
