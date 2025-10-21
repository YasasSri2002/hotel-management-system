package com.yasas.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasas.hotel.entity.RoomEntity;
import com.yasas.hotel.exception.RoomIsNotFoundException;
import com.yasas.hotel.model.RoomModel;
import com.yasas.hotel.repository.RoomRepository;
import com.yasas.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final ObjectMapper mapper;

    @Override
    public ResponseEntity<List<RoomModel>> retrieveAllRoom(){
        Iterable<RoomEntity> rooms = roomRepository.findAll();

        List<RoomModel> roomModelList = new ArrayList<>();
        rooms.forEach(roomEntity -> roomModelList.add
                (
                        mapper.convertValue(roomEntity, RoomModel.class
                )));
        return ResponseEntity.ok(roomModelList);
    }

    @Override
    public ResponseEntity<RoomModel> persistNewRoom(RoomModel roomModel){

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomId(roomModel.getRoomId());
        roomEntity.setType(roomModel.getType());
        roomEntity.setDescription(roomModel.getDescription());
        roomEntity.setPrice(roomModel.getPrice());
        roomEntity.setRoomSize(roomModel.getRoomSize());
        roomEntity.setMinGuestSize(roomModel.getMinGuestSize());
        roomEntity.setMaxGuestSize(roomModel.getMaxGuestSize());

        return ResponseEntity.ok(
                mapper.convertValue(
                roomRepository.save(
                        mapper.convertValue(roomModel, RoomEntity.class)
                )
                , RoomModel.class)
        );


    }

    @Override
    public ResponseEntity<Map<String,String>> deleteById(Long roomId) {
        if(roomRepository.existsById(roomId)){
            roomRepository.deleteById(roomId);
            return ResponseEntity.ok(Map.of("Delete message",
                    "Data has been successfully deleted"));
        }
        return ResponseEntity.ok(Map.of("Delete message",
                "couldn't find the id"));

    }

    @Override
    public ResponseEntity<RoomModel> update(RoomModel roomModel) {

        Optional<RoomEntity> existingEntity
                = roomRepository.findById(roomModel.getRoomId());

        if(existingEntity.isEmpty()){
            throw new RoomIsNotFoundException("Incorrect room id");
        }
        RoomEntity roomEntity = existingEntity.get();

        if(roomModel.getDescription() != null){
            roomEntity.setDescription(roomModel.getDescription());
        }
        if(roomModel.getType() != null){
            roomEntity.setType(roomModel.getType());
        }
        if(roomModel.getPrice() != null){
            roomEntity.setPrice(roomModel.getPrice());
        }
        if(roomModel.getRoomSize() != null){
            roomEntity.setRoomSize(roomModel.getRoomSize());
        }
        if(roomModel.getMaxGuestSize() != null){
            roomEntity.setMaxGuestSize(roomModel.getMaxGuestSize());
        }
        if(roomModel.getMinGuestSize() != null){
            roomEntity.setMinGuestSize(roomModel.getMinGuestSize());
        }


        return ResponseEntity.ok(
                mapper.convertValue(
                roomRepository.save(roomEntity),RoomModel.class));
    }



    @Override
    public ResponseEntity<List<RoomModel>> getAllByType(String type) {

        Iterable<RoomEntity> allByType = roomRepository.findAllByType(type);

        List<RoomModel> roomModelListByType = new ArrayList<>();
        allByType.forEach(roomEntity-> roomModelListByType.add
                (mapper.convertValue(roomEntity, RoomModel.class)));

        return ResponseEntity.ok(roomModelListByType);

    }

    @Override
    public ResponseEntity<RoomModel> getRoomById(Long roomId) {
        RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(() ->
                new RoomIsNotFoundException("Room does not exist"));
        return ResponseEntity.ok(
                RoomModel.builder()
                .roomId(roomEntity.getRoomId())
                .roomSize(roomEntity.getRoomSize())
                .price(roomEntity.getPrice())
                .description(roomEntity.getDescription())
                .minGuestSize(roomEntity.getMinGuestSize())
                .maxGuestSize(roomEntity.getMaxGuestSize())
                .type(roomEntity.getType())
                .build()
        );

    }

}
