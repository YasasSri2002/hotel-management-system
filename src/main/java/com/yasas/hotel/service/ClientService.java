package com.yasas.hotel.service;

import com.yasas.hotel.entity.ClientEntity;
import com.yasas.hotel.model.ClientModel;
import org.springframework.http.ResponseEntity;


public interface ClientService {

    ResponseEntity<ClientModel> create(ClientModel user);

    ResponseEntity<Iterable<ClientEntity>>get();

}
