package com.yasas.hotel.model;


import com.yasas.hotel.entity.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {

    private UUID id;

    private String name;

    private String contactNo;

    private String email;

    private String password;

    private String role;

    private ProfileEntity profile;
}
