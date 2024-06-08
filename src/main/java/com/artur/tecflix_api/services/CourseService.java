package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.CourseDTO;
import com.artur.tecflix_api.data.DTO.v1.ModuleDTO;
import com.artur.tecflix_api.data.DTO.v1.ProfessorDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Course;
import com.artur.tecflix_api.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class CourseService {
    Logger logger = Logger.getLogger(CourseService.class.getName());

    @Autowired
    CourseRepository repository;

    @Autowired
    ModuleService moduleService;

    @Autowired
    ProfessorService professorService;

    public CourseDTO findById(UUID id) {
        logger.info("finding one course");

        return Mapper.parseObject(
                repository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No records found for this id")
                        ),
                CourseDTO.class
        );
    }

    public List<CourseDTO> findAll() {
        logger.info("finding all courses");

        return Mapper.parseObjectList(repository.findAll(), CourseDTO.class);
    }

    public CourseDTO create(CourseDTO courseDTO, UUID professorId) {
        logger.info("creating one course");

        ProfessorDTO professorDTO = professorService.findById(professorId);
        courseDTO.setProfessor(professorDTO);

        Course entity = Mapper.parseObject(courseDTO, Course.class);

        return Mapper.parseObject(repository.save(entity), CourseDTO.class);
    }

    public CourseDTO addModule(CourseDTO courseDTO, ModuleDTO moduleDTO) {
        logger.info("add one module");

        moduleService.create(moduleDTO);
        courseDTO.getModules().add(moduleDTO);

        Course course = Mapper.parseObject(courseDTO, Course.class);

        return Mapper.parseObject(repository.save(course), CourseDTO.class);
    }
}
