package com.yasas.hotel.repository;

import com.yasas.hotel.entity.StaffEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface StaffRepository extends CrudRepository<StaffEntity, UUID> {

    Optional<StaffEntity> findByEmail(String email);

}
