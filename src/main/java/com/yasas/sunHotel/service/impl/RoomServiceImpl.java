package com.yasas.sunHotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasas.sunHotel.entity.RoomEntity;
import com.yasas.sunHotel.model.Room;
import com.yasas.sunHotel.repository.RoomRepository;
import com.yasas.sunHotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final ObjectMapper mapper;

    @Override
    public List<Room> retrieveAllRoom(){
        Iterable<RoomEntity> rooms = roomRepository.findAll();

        List<Room> roomList= new ArrayList<>();
        rooms.forEach(roomEntity -> roomList.add(mapper.convertValue(roomEntity, Room.class)));
        return roomList;
    }

    @Override
    public Room persistNewRoom(Room room){
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomId(room.getRoomId());
        roomEntity.setType(room.getType());
        roomEntity.setDescription(room.getDescription());
        roomEntity.setPrice(room.getPrice());

        return mapper.convertValue(
                roomRepository.save(mapper.convertValue(room, RoomEntity.class))
                ,Room.class);


    }

    @Override
    public String deleteById(Integer roomId) {
        if(roomRepository.existsById(roomId)){
            roomRepository.deleteById(roomId);
            return "SUCCESS";
        }
        return "FAILED";

    }


    @Override
    public Room update(Integer roomId, Room room) {
        return mapper.convertValue(
                roomRepository.save(mapper.convertValue
                        (room, RoomEntity.class)),
                Room.class);
    }

    @Override
    public List<Room> getAllByType(String type) {
        Iterable<RoomEntity> allByType = roomRepository.findAllByType(type);

        List<Room> roomListByType = new ArrayList<>();
        allByType.forEach(roomEntity-> roomListByType.add(mapper.convertValue(roomEntity, Room.class)));

        return roomListByType;

    }

}
