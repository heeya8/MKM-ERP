package com.mkm.erp.domain.manage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ProductionPlanResponse {
    private Long id;  // 생산계획 ID
    private String productName;  // 제품명
    private int quantity;   // 수량
    private LocalDateTime start;   // 작업 시작일
    private LocalDateTime finish;  // 작업 마감일
    private LocalDateTime createdAt; // 생성일시
}
