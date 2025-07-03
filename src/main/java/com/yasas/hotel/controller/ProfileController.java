package com.yasas.hotel.controller;

import com.yasas.hotel.model.ProfileModel;
import com.yasas.hotel.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<Iterable<ProfileModel>> getAll(){
        return profileService.getAll();
    }

}
