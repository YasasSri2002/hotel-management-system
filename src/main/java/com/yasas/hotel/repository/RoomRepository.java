package com.yasas.hotel.repository;

import com.yasas.hotel.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository  extends CrudRepository<RoomEntity, Integer> {


    Iterable<RoomEntity> findAllByType(String type);



}
