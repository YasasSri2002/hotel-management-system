package com.yasas.hotel.config;

import com.yasas.hotel.entity.ClientEntity;
import com.yasas.hotel.entity.SecurityUserEntity;
import com.yasas.hotel.repository.ClientRepository;
import com.yasas.hotel.repository.SecurityUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService{

    private final SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        SecurityUserEntity user = securityUserRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("user name is not valid"));

        List<SimpleGrantedAuthority> simpleGrantedAuthorities =
                List.of(new SimpleGrantedAuthority(user.getRole()));

        return new User(user.getUsername(), user.getPassword(), simpleGrantedAuthorities);
    }
}
