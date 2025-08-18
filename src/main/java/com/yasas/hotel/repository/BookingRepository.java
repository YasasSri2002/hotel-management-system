package com.yasas.hotel.repository;

import com.yasas.hotel.entity.BookingEntity;

import org.springframework.data.repository.CrudRepository;


import java.util.UUID;

public interface BookingRepository extends CrudRepository<BookingEntity, UUID> {



}
