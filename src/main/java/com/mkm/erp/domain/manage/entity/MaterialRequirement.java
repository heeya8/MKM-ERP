package com.mkm.erp.domain.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialRequirement {
    private String materialId;
    private int requiredQuantity;
}
