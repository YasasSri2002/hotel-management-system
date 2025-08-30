package com.yasas.hotel.repository;

import com.yasas.hotel.entity.HotelServiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface HotelServicesRepository extends CrudRepository<HotelServiceEntity, UUID> {
}
