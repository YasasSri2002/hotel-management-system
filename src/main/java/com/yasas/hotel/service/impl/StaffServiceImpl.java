package com.yasas.hotel.service.impl;

import com.yasas.hotel.entity.StaffEntity;
import com.yasas.hotel.exception.PhoneNumberIsWrongException;
import com.yasas.hotel.model.StaffModel;
import com.yasas.hotel.model.response.StaffResponseModel;
import com.yasas.hotel.repository.StaffRepository;
import com.yasas.hotel.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public ResponseEntity<StaffResponseModel> newMember(StaffModel staffModel) {

        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setEmail(staffModel.getEmail());
        staffEntity.setName(staffModel.getName());
        staffEntity.setJobRole(staffModel.getJobRole());

        staffEntity.setPhoneNo(staffModel.getPhoneNo());


        StaffEntity save = staffRepository.save(staffEntity);

        return ResponseEntity.ok(
                StaffResponseModel.builder()
                        .id(save.getId())
                        .email(save.getEmail())
                        .name(save.getName())
                        .jobRole(save.getJobRole())
                        .phoneNo(save.getPhoneNo())
                        .build()
        );
    }
}
