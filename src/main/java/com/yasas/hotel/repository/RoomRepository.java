package com.yasas.hotel.repository;

import com.yasas.hotel.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface RoomRepository  extends CrudRepository<RoomEntity, Long> {


    Iterable<RoomEntity> findAllByType(String type);



}
