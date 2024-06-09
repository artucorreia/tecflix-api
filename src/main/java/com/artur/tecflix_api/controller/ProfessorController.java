package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.ProfessorDTO;
import com.artur.tecflix_api.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "professors")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProfessorDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfessorDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProfessorDTO create(@RequestBody ProfessorDTO professorDTO) {
        return service.create(professorDTO);
    }

//    @GetMapping(
//            value = "/{id}/courses",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public List<CourseDTO> findCoursesByProfessorId(@PathVariable UUID id) {
//        return service.findCoursesByProfessorId(id);
//    }

}
