package com.mkm.erp.domain.manage.service;

import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.manage.dto.request.PurchaseOrderRequest;
import com.mkm.erp.domain.manage.dto.response.PurchaseOrderResponse;
import com.mkm.erp.domain.manage.entity.PurchaseOrder;
import com.mkm.erp.domain.manage.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderResponse createPurchaseOrder(PurchaseOrderRequest request) {
        PurchaseOrder purchaseOrder = new PurchaseOrder(request.getMaterialName(), request.getOrderQuantity(), LocalDate.now());
        PurchaseOrder savedOrder = purchaseOrderRepository.save(purchaseOrder);
        return mapToResponse(savedOrder);
    }

    public ResponseDto<PurchaseOrderResponse> getAllPurchaseOrders(int page, int size, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        if ("recent".equals(sortBy)) {
            sort = Sort.by(Sort.Direction.DESC, "orderDate");
        } else if ("oldest".equals(sortBy)) {
            sort = Sort.by(Sort.Direction.ASC, "orderDate");
        }

        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<PurchaseOrder> purchaseOrderPage = purchaseOrderRepository.findAll(pageable);

        return new ResponseDto<>(
                purchaseOrderPage.getContent().stream()
                        .map(this::mapToResponse)
                        .collect(Collectors.toList()),
                purchaseOrderPage.getNumber() + 1,
                purchaseOrderPage.getSize(),
                purchaseOrderPage.getTotalElements(),
                purchaseOrderPage.getTotalPages(),
                purchaseOrderPage.isLast()
        );
    }

    public PurchaseOrderResponse getPurchaseOrder(Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found. ID: " + id));
        return mapToResponse(purchaseOrder);
    }

    public PurchaseOrderResponse updatePurchaseOrder(Long id, PurchaseOrderRequest request) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found. ID: " + id));

        purchaseOrder.setMaterialName(request.getMaterialName());
        purchaseOrder.setOrderQuantity(request.getOrderQuantity());
        PurchaseOrder updatedOrder = purchaseOrderRepository.save(purchaseOrder);
        return mapToResponse(updatedOrder);
    }

    public void deletePurchaseOrder(Long id) {
        purchaseOrderRepository.deleteById(id);
    }

    private PurchaseOrderResponse mapToResponse(PurchaseOrder purchaseOrder) {
        return new PurchaseOrderResponse(
                purchaseOrder.getId(),
                purchaseOrder.getMaterialName(),
                purchaseOrder.getOrderQuantity(),
                purchaseOrder.getOrderDate()
        );
    }
}
