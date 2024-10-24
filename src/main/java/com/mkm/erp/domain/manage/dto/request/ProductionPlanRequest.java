package com.mkm.erp.domain.manage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ProductionPlanRequest {
    private Long productId; // 제품 ID
    private int quantity;   // 수량
    private LocalDateTime start;   // 작업 시작일
    private LocalDateTime finish;  // 작업 마감일
}
