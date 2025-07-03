package com.yasas.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasas.hotel.entity.ProfileEntity;
import com.yasas.hotel.entity.ClientEntity;

import com.yasas.hotel.exception.ClientAlreadyExistException;
import com.yasas.hotel.model.ClientModel;
import com.yasas.hotel.repository.ProfileRepository;
import com.yasas.hotel.repository.ClientRepository;
import com.yasas.hotel.service.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ObjectMapper mapper;

    private final ProfileRepository profileRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public ResponseEntity<ClientModel> create(ClientModel client) {
        Optional<ClientEntity> byEmail =
                clientRepository.findByEmail(client.getEmail());



        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(client.getName());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setContactNo(client.getContactNo());
        clientEntity.setPassword(passwordEncoder.encode(client.getPassword()));
        clientEntity.setRole(client.getRole());

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setProfilePicUrl(client.getProfile().getProfilePicUrl());
        ProfileEntity saveProfile = profileRepository.save(profileEntity);

        clientEntity.setProfile(saveProfile);

        if(byEmail.isPresent()) throw new ClientAlreadyExistException
                ("email is already register in database");

        return ResponseEntity.ok().body(mapper.convertValue(
                clientRepository.save(clientEntity), ClientModel.class)
        );
    }

    @Override
    public ResponseEntity<Iterable<ClientEntity>>get() {
        Iterable<ClientEntity> all = clientRepository.findAll();

        ArrayList<ClientEntity> userEntities = new ArrayList<>();

        all.forEach(userEntities::add);

        return ResponseEntity.ok().body(userEntities);
    }
}
