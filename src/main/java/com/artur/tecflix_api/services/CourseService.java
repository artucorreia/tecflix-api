package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.CourseDTO;
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
    private CourseRepository repository;

    @Autowired
    private ProfessorService professorService;

    public CourseDTO findById(UUID courseId) {
        logger.info("Finding one course");

        return Mapper.parseObject(
                repository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")),
                CourseDTO.class
        );
    }

    public List<CourseDTO> findAll() {
        logger.info("Finding all courses");

        return Mapper.parseObjectList(repository.findAll(), CourseDTO.class);
    }

    public CourseDTO create(CourseDTO courseDTO) {
        logger.info("Creating one course");

        Course entity = Mapper.parseObject(courseDTO, Course.class);

        return Mapper.parseObject(repository.save(entity), CourseDTO.class);
    }

//    public List<CourseDTO> findByProfessorId(UUID professorId) {
//        return Mapper.parseObjectList(
//                repository.findByProfessorId(professorId),
//                CourseDTO.class
//        );
//    }
}
