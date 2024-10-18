package com.mkm.erp.domain.manage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PurchaseOrderResponse {
    private Long id;
    private String materialName;
    private int orderQuantity;
    private LocalDate orderDate;
}
