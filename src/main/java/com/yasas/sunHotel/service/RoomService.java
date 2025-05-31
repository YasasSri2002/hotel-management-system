package com.yasas.sunHotel.service;

import com.yasas.sunHotel.entity.RoomEntity;
import com.yasas.sunHotel.model.Room;

import java.util.List;

public interface RoomService  {

   Room persistNewRoom(Room room);

    List<Room> retrieveAllRoom();

    String deleteById(Integer roomId);

    Room update(Integer roomId, Room room);

    List<Room> getAllByType(String type);
}
