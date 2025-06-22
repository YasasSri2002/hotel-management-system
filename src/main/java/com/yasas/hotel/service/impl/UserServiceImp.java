package com.yasas.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasas.hotel.entity.ProfileEntity;
import com.yasas.hotel.entity.UserEntity;

import com.yasas.hotel.model.UserModel;
import com.yasas.hotel.repository.ProfileRepository;
import com.yasas.hotel.repository.UserRepository;
import com.yasas.hotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final ObjectMapper mapper;

    private final ProfileRepository profileRepository;

    @Override
    public ResponseEntity<UserModel> create(UserModel user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setContactNo(user.getContactNo());
        if (user.getProfileId() != null) {
            ProfileEntity profile = profileRepository.findById(user.getProfileId())
                    .orElseThrow(() -> new RuntimeException("Profile not found"));
            userEntity.setProfile(profile);
        }
        user.setProfileId(user.getProfileId());

        return ResponseEntity.ok().body(mapper.convertValue(
                userRepository.save(userEntity),UserModel.class)
        );
    }

    @Override
    public ResponseEntity<Iterable<UserEntity>>get() {
        Iterable<UserEntity> all = userRepository.findAll();

        ArrayList<UserEntity> userEntities = new ArrayList<>();

        all.forEach(userEntities::add);

        return ResponseEntity.ok().body(userEntities);
    }
}
