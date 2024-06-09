package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.CourseDTO;
import com.artur.tecflix_api.data.DTO.v1.OccupationDTO;
import com.artur.tecflix_api.data.DTO.v1.ProfessorDTO;
import com.artur.tecflix_api.data.DTO.v1.UserDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Professor;
import com.artur.tecflix_api.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ProfessorService {
    private final Logger logger = Logger.getLogger(ProfessorService.class.getName());

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private OccupationService occupationService;

//    @Autowired
//    CourseService courseService;

    public ProfessorDTO findById(UUID id) {
        logger.info("Finding one professor");

        return Mapper.parseObject(
                repository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("No records found for this id")
                ),
                ProfessorDTO.class
        );
    }

    public List<ProfessorDTO> findAll() {
        logger.info("Finding all professors");

        return Mapper.parseObjectList(repository.findAll(), ProfessorDTO.class);
    }

    public ProfessorDTO create(ProfessorDTO professorDTO) {
        logger.info("Creating one professor");

        UserDTO userDTO = userService.findById(professorDTO.getUser().getId());
        professorDTO.setUser(userDTO);

        OccupationDTO occupationDTO = occupationService.findById(professorDTO.getOccupation().getId());
        professorDTO.setOccupation(occupationDTO);

        Professor professor = Mapper.parseObject(professorDTO, Professor.class);
        return Mapper.parseObject(repository.save(professor), ProfessorDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one person");

        Professor professor = Mapper.parseObject(findById(id), Professor.class);

        repository.delete(professor);
    }

//    public List<CourseDTO> findCoursesByProfessorId(UUID id) {
//        return courseService.findByProfessorId(id);
//    }
}
