package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.SocialDTO;
import com.artur.tecflix_api.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/socials")
public class SocialController {
    @Autowired
    private SocialService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SocialDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SocialDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SocialDTO create(@RequestBody SocialDTO socialDTO) {
        return service.create(socialDTO);
    }
}
