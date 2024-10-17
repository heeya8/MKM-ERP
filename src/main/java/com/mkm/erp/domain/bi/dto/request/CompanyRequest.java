package com.mkm.erp.domain.bi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanyRequest {
    private String name;
    private String owner;
    private String address;
    private String email;
    private String business_num;
}
