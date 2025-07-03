package com.yasas.hotel.repository;

import com.yasas.hotel.entity.ClientEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends CrudRepository<ClientEntity, UUID> {

    Optional<ClientEntity> findByEmail(String email);
}
