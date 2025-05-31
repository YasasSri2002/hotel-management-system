package com.yasas.sunHotel.repository;

import com.yasas.sunHotel.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository  extends CrudRepository<RoomEntity, Integer> {


    Iterable<RoomEntity> findAllByType(String type);
}
