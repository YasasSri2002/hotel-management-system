package com.yasas.hotel.repository;

import com.yasas.hotel.entity.SecurityUserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface SecurityUserRepository extends CrudRepository<SecurityUserEntity, UUID> {

   Optional<SecurityUserEntity> findByUsername(String username);

}
