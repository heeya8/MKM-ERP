package com.mkm.erp.domain.bi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponse {
    private String itemCode;
    private String name;
    private String category;
    private String subCategory;
    private String unit;
}
