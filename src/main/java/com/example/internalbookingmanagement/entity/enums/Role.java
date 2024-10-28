package com.example.internalbookingmanagement.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    EMPLOYEE,
    COMPANY_ADMIN,
    SUPER_ADMIN;


    @Override
    public String getAuthority() {
        return this.name();
    }
}
