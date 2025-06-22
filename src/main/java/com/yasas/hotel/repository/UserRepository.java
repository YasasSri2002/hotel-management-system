package com.yasas.hotel.repository;

import com.yasas.hotel.entity.UserEntity;
import com.yasas.hotel.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
