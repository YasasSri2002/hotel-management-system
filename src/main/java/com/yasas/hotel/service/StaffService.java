package com.yasas.hotel.service;

import com.yasas.hotel.model.StaffModel;
import com.yasas.hotel.model.response.StaffResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface StaffService {

    ResponseEntity<StaffResponseModel> newMember(StaffModel staffModel);

    ResponseEntity<List<StaffResponseModel>> viewAllMembers();

    ResponseEntity<StaffResponseModel> updateMember(String email, StaffModel staffModel);


}
