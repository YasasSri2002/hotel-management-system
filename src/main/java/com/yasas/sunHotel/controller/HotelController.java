package com.yasas.sunHotel.controller;

import com.yasas.sunHotel.model.Room;
import com.yasas.sunHotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class HotelController {

    private final RoomService roomService;



    @PostMapping("/save-room")
    public Room persistNewRoom(@RequestBody Room room){
        return roomService.persistNewRoom(room);
    }

    @GetMapping("get-room")
    public List<Room> getAllRoom(){
        return roomService.retrieveAllRoom();
    }

    @GetMapping("/get-room-by-type")
    public List<Room> getAllByType(@RequestParam String type){
        return roomService.getAllByType(type);
    }

    @DeleteMapping("/by-roomId")
    public Map<String, String> deleteById(@RequestParam Integer roomId){

        return Collections.singletonMap("DELETE",roomService.deleteById(roomId));

    }

    @PutMapping("/by-roomId/{roomId}")
    public Room update(@PathVariable Integer roomId,@RequestBody Room room ){
        return roomService.update(roomId,room);
    }


}
