package com.yasas.hotel.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StaffModel {

    private String name;

    private String jobRole;

    private String email;

    private String phoneNo;

}
