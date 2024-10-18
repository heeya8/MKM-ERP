package com.mkm.erp.domain.manage.dto.response;

import com.mkm.erp.domain.manage.entity.MaterialRequirement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialRequirementResponse {
    private List<MaterialRequirement> materials;
    private List<MaterialRequirement> shortages;
}