package com.yasas.hotel.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecurityUserModel {

    private String username;

    private String password;

    private String role;

}
