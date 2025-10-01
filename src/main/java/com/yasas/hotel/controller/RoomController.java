package com.yasas.hotel.controller;

import com.yasas.hotel.model.RoomModel;
import com.yasas.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class RoomController {

    private final RoomService roomService;


    @PostMapping("/save-room")
    public ResponseEntity<RoomModel> persistNewRoom(@RequestBody RoomModel roomModel){
        return roomService.persistNewRoom(roomModel);
    }

    @GetMapping("get-room")
    public ResponseEntity<List<RoomModel>> getAllRoom(){
        return roomService.retrieveAllRoom();
    }

    @GetMapping("/get-room-by-type")
    public ResponseEntity<List<RoomModel>> getAllByType(@RequestParam String type){
        return roomService.getAllByType(type);
    }

    @DeleteMapping("/by-roomId")
    public ResponseEntity<Map<String, String>>deleteById(@RequestParam Long roomId){
        return roomService.deleteById(roomId);

    }

    @PatchMapping("/by-room")
    public ResponseEntity<RoomModel> update(@RequestBody RoomModel roomModel){
        return roomService.update(roomModel);
    }


}
