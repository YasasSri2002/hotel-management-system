package com.yasas.hotel.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private UUID id;

    private String name;

    private String contactNo;

    private String email;

    private UUID profileId;
}
