package com.yasas.hotel.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffResponseModel {

    private UUID id;

    private String name;

    private String jobRole;

    private String email;

    private String phoneNo;
}
