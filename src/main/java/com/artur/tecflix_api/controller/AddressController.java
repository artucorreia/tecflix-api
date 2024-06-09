package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.AddressDTO;
import com.artur.tecflix_api.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AddressDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AddressDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AddressDTO create(@RequestBody AddressDTO addressDTO) {
        return service.create(addressDTO);
    }
}
