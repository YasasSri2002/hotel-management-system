package com.yasas.hotel.service;

import com.yasas.hotel.model.StaffModel;
import com.yasas.hotel.model.response.StaffResponseModel;
import org.springframework.http.ResponseEntity;

public interface StaffService {

    ResponseEntity<StaffResponseModel> newMember(StaffModel staffModel);


}
