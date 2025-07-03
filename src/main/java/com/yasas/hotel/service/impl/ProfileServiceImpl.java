package com.yasas.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasas.hotel.entity.ProfileEntity;
import com.yasas.hotel.model.ProfileModel;
import com.yasas.hotel.repository.ProfileRepository;
import com.yasas.hotel.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    private final ObjectMapper mapper;


    @Override
    public ResponseEntity<Iterable<ProfileModel>> getAll() {
        Iterable<ProfileEntity> allProfiles = profileRepository.findAll();

        ArrayList<ProfileModel> profileModels = new ArrayList<>();

        allProfiles.forEach(entity ->
                profileModels.add(
                        mapper.convertValue(entity,ProfileModel.class)
                ));

        return ResponseEntity.ok(profileModels);
    }
}
