package com.yasas.hotel.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ProfileModel {

    private UUID id;

    private String profilePicUrl;
}
