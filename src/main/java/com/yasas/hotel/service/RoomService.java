package com.yasas.hotel.service;

import com.yasas.hotel.model.RoomModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface RoomService  {

    ResponseEntity<RoomModel> persistNewRoom(RoomModel roomModel);

    ResponseEntity<List<RoomModel>> retrieveAllRoom();

    ResponseEntity<Map<String,String>> deleteById(Long roomId);

    ResponseEntity<RoomModel> update(RoomModel roomModel);

    ResponseEntity<List<RoomModel>> getAllByType(String type);
}
