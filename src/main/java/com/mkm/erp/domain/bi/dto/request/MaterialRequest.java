package com.mkm.erp.domain.bi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class MaterialRequest {
    private String name;
    private int quantity;
    private String unit;
}
