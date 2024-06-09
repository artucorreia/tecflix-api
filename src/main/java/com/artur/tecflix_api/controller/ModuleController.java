package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.ModuleDTO;
import com.artur.tecflix_api.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/modules")
public class ModuleController {

    @Autowired
    private ModuleService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ModuleDTO> findById(@PathVariable UUID id) {
        return service.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ModuleDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ModuleDTO create(@RequestBody ModuleDTO moduleDTO) {
        return service.create(moduleDTO);
    }

}
