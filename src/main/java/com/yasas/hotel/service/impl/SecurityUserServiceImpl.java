package com.yasas.hotel.service.impl;

import com.yasas.hotel.entity.SecurityUserEntity;
import com.yasas.hotel.model.SecurityUserModel;
import com.yasas.hotel.repository.SecurityUserRepository;
import com.yasas.hotel.service.SecurityUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserServiceImpl implements SecurityUserService {

    private final SecurityUserRepository securityUserRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<SecurityUserModel> register(SecurityUserModel userModel) {

        SecurityUserEntity securityUserEntity = new SecurityUserEntity();
        securityUserEntity.setUsername(userModel.getUsername());
        securityUserEntity.setPassword(passwordEncoder.encode(userModel.getPassword()));
        String role = userModel.getRole();
        if(role.startsWith("ROLE_")){
            securityUserEntity.setRole(role);
        }else{
            securityUserEntity.setRole("ROLE_"+role);
        }
        SecurityUserEntity save = securityUserRepository.save(securityUserEntity);

        return ResponseEntity.ok(SecurityUserModel.builder()
                .username(save.getUsername())
                .password(save.getPassword())
                .build()
        );
    }


}
