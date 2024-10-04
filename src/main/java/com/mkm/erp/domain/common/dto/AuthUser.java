package com.mkm.erp.domain.common.dto;

import com.mkm.erp.domain.user.entity.UserRole;
import lombok.Getter;

@Getter
public class AuthUser {

    private final Long id;
    private final String email;
    private final String name;
    private final UserRole userRole;

    public AuthUser(Long id, String email, String name, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }
}
