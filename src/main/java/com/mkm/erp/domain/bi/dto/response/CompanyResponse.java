package com.mkm.erp.domain.bi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanyResponse {
    private Long id;
    private String name;
    private String owner;
    private String address;
    private String email;
    private String businessNum;
    private String phone;
}
