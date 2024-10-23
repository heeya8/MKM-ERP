package com.mkm.erp.domain.manage.controller.api;

import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.manage.dto.request.PurchaseOrderRequest;
import com.mkm.erp.domain.manage.dto.response.PurchaseOrderResponse;
import com.mkm.erp.domain.manage.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manage/inventory")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseOrderResponse> createPurchaseOrder(@RequestBody PurchaseOrderRequest request) {
        PurchaseOrderResponse response = purchaseOrderService.createPurchaseOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/purchase")
    public ResponseEntity<ResponseDto<PurchaseOrderResponse>> getAllPurchaseOrders(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(purchaseOrderService.getAllPurchaseOrders(page, size, sortBy));
    }

    @GetMapping("/purchase/{id}")
    public ResponseEntity<PurchaseOrderResponse> getPurchaseOrder(@PathVariable Long id) {
        PurchaseOrderResponse response = purchaseOrderService.getPurchaseOrder(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/purchase/{id}")
    public ResponseEntity<PurchaseOrderResponse> updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrderRequest request) {
        PurchaseOrderResponse response = purchaseOrderService.updatePurchaseOrder(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/purchase/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long id) {
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.noContent().build();
    }
}
