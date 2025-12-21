package com.yasas.hotel.service.impl;

import com.yasas.hotel.entity.StaffEntity;
import com.yasas.hotel.exception.StaffMemberDoesNotExistException;
import com.yasas.hotel.model.StaffModel;
import com.yasas.hotel.model.response.StaffResponseModel;
import com.yasas.hotel.repository.StaffRepository;
import com.yasas.hotel.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public ResponseEntity<List<StaffResponseModel>> viewAllMembers() {
        Iterable<StaffEntity> allEntities = staffRepository.findAll();

        ArrayList<StaffResponseModel> staffResponseModelsList = new ArrayList<>();

        allEntities.forEach(staffEntity ->{
            StaffResponseModel staffResponseModel = new StaffResponseModel();
            staffResponseModel.setEmail(staffEntity.getEmail());
            staffResponseModel.setName(staffEntity.getName());
            staffResponseModel.setId(staffEntity.getId());
            staffResponseModel.setJobRole(staffEntity.getJobRole());
            staffResponseModel.setPhoneNo(staffEntity.getPhoneNo());
            staffResponseModelsList.add(staffResponseModel);

        });

        return ResponseEntity.ok(staffResponseModelsList);


    }

    @Override
    public ResponseEntity<StaffResponseModel> updateMember(
            String email, StaffModel staffModel) {

        StaffEntity byEmail = staffRepository.findByEmail(email).orElseThrow(()->
                new StaffMemberDoesNotExistException(
                        "member does not exist in database under this email" + email)
                );

        if(staffModel.getName() != null){
            byEmail.setName(staffModel.getName());
        }
        if(staffModel.getPhoneNo() !=null){
            byEmail.setPhoneNo(staffModel.getPhoneNo());
        }
        if(staffModel.getJobRole() != null){
            byEmail.setJobRole(staffModel.getJobRole());
        }



        return ResponseEntity.ok(
                StaffResponseModel.builder()
                        .id(byEmail.getId())
                        .email(byEmail.getEmail())
                        .name(byEmail.getName())
                        .jobRole(byEmail.getJobRole())
                        .phoneNo(byEmail.getPhoneNo())
                        .build());
    }

    @Override
    public ResponseEntity<Long> staffCount() {
        return ResponseEntity.ok(staffRepository.count());
    }
}
