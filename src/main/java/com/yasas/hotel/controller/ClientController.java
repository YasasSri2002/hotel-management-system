package com.yasas.hotel.controller;

import com.yasas.hotel.entity.ClientEntity;
import com.yasas.hotel.model.ClientModel;
import com.yasas.hotel.service.ClientService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientModel>create(@RequestBody ClientModel client){
        return clientService.create(client);
    }

    @GetMapping
    public ResponseEntity<Iterable<ClientEntity>>getUser(){
        return clientService.get();
    }
}
