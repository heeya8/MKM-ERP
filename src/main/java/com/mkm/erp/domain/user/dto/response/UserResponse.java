package com.mkm.erp.domain.user.dto.response;

import lombok.Getter;

@Getter
public class UserResponse {

    private final Long id;
    private final String email;
    private final String name;

    public UserResponse(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
