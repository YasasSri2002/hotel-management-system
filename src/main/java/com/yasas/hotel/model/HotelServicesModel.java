package com.yasas.hotel.model;

import com.yasas.hotel.entity.BookingEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class HotelServicesModel {

    private String name;

    private String description;

    private Double price;

}
