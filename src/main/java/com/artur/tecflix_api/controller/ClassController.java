package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.ClassDTO;
import com.artur.tecflix_api.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/classes")
public class ClassController {

    @Autowired
    private ClassService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ClassDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClassDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ClassDTO create(@RequestBody ClassDTO courseDTO) {
        return service.create(courseDTO);
    }
}
