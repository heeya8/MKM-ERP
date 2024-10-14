package com.mkm.erp.domain.bi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MaterialResponse {
    private Long id;
    private String itemCode;
    private String name;
    private int quantity;
    private String unit;
    private String subcategoryName;
}
