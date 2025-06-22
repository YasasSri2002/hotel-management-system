package com.yasas.hotel.repository;

import com.yasas.hotel.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProfileRepository extends CrudRepository<ProfileEntity,UUID> {
}
