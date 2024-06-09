package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.OccupationDTO;
import com.artur.tecflix_api.services.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/occupations")
public class OccupationController {

    @Autowired
    private OccupationService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public OccupationDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OccupationDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public OccupationDTO create(@RequestBody OccupationDTO occupationDTO) {
        return service.create(occupationDTO);
    }
}
