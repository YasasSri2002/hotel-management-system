package com.yasas.hotel.controller;

import com.yasas.hotel.model.StaffModel;
import com.yasas.hotel.model.response.StaffResponseModel;
import com.yasas.hotel.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/staff")
public class StaffController {

    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<StaffResponseModel>newMemberRegister(
            @RequestBody StaffModel staffModel){
        return staffService.newMember(staffModel);
    }

    @GetMapping
    public ResponseEntity<List<StaffResponseModel>>viewAllMembers(){
        return staffService.viewAllMembers();
    }

    @PatchMapping
    public ResponseEntity<StaffResponseModel>update(
            @RequestParam String email, @RequestBody StaffModel staffModel){
        return staffService.updateMember(email,staffModel);
    }

    @GetMapping("/count")
    public ResponseEntity<Long>staffCount(){
        return staffService.staffCount();
    }

    @GetMapping("/by-id")
    public ResponseEntity<StaffResponseModel>getById(UUID id){
        return staffService.getById(id);
    }


}
