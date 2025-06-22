package com.yasas.hotel.service;

import com.yasas.hotel.entity.UserEntity;
import com.yasas.hotel.model.UserModel;
import org.springframework.http.ResponseEntity;


public interface UserService {

    ResponseEntity<UserModel> create(UserModel user);

    ResponseEntity<Iterable<UserEntity>>get();

}
