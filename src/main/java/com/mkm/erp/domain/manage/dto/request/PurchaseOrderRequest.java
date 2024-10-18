package com.mkm.erp.domain.manage.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrderRequest {
    private String materialName;
    private int orderQuantity;
}
