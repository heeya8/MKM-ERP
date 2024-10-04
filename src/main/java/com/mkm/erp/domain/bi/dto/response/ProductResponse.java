package com.mkm.erp.domain.bi.dto.response;

import com.mkm.erp.domain.bi.entity.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private int quantity;
    private String unit;
}
