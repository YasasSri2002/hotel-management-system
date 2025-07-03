package com.yasas.hotel.config;

import com.yasas.hotel.entity.ClientEntity;
import com.yasas.hotel.repository.ClientRepository;
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
public class ClientUserDetailsService implements UserDetailsService{

    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        ClientEntity client = clientRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("user name is not valid"));

        List<SimpleGrantedAuthority> simpleGrantedAuthorities =
                List.of(new SimpleGrantedAuthority(client.getRole()));

        return new User(client.getEmail(), client.getPassword(), simpleGrantedAuthorities);
    }
}
