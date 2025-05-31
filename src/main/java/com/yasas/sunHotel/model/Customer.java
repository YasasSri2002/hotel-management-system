package com.yasas.sunHotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String name;

    private String contactNo;

    private String email;
}
