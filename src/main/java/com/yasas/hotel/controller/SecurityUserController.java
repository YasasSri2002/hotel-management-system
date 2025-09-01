package com.yasas.hotel.controller;

import com.yasas.hotel.model.SecurityUserModel;
import com.yasas.hotel.service.SecurityUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/login")
public class SecurityUserController {

    private final SecurityUserService securityUserService;

    @PostMapping("/register")
    public ResponseEntity<SecurityUserModel>register(
            @RequestBody SecurityUserModel userModel){
        return securityUserService.register(userModel);
    }

}
