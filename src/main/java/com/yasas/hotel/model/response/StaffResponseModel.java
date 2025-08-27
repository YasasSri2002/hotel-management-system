package com.yasas.hotel.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StaffResponseModel {

    private UUID id;

    private String name;

    private String jobRole;

    private String email;

    private String phoneNo;
}
