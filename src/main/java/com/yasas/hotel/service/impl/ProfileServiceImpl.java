package com.yasas.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasas.hotel.entity.ProfileEntity;
import com.yasas.hotel.model.ProfileModel;
import com.yasas.hotel.repository.ProfileRepository;
import com.yasas.hotel.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    private final ObjectMapper mapper;

    @Override
    public ResponseEntity<ProfileModel> create(ProfileModel profile) {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setProfilePicUrl(profile.getProfilePicUrl());
        return ResponseEntity.ok(mapper.convertValue(
                profileRepository.save(profileEntity),
                ProfileModel.class));
    }
}
