package com.yasas.hotel.service;

import com.yasas.hotel.model.SecurityUserModel;
import com.yasas.hotel.service.impl.SecurityUserServiceImpl;
import org.springframework.http.ResponseEntity;

public interface SecurityUserService  {

    ResponseEntity<SecurityUserModel>register(SecurityUserModel userModel);


}
