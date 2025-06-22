package com.yasas.hotel.service;

import com.yasas.hotel.model.ProfileModel;
import org.springframework.http.ResponseEntity;

public interface ProfileService {

    ResponseEntity<ProfileModel>create(ProfileModel profile);

}
