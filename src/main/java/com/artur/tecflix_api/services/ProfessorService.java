package com.artur.tecflix_api.services;

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
    ProfessorRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    OccupationService occupationService;

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

    public ProfessorDTO create(ProfessorDTO professorDTO, UUID userId, UUID occupationId) {
        logger.info("Creating one professor");

        UserDTO userDTO = userService.findById(userId);
        professorDTO.setUser(userDTO);

        OccupationDTO occupationDTO = occupationService.findById(occupationId);
        professorDTO.setOccupation(occupationDTO);

        Professor professor = Mapper.parseObject(professorDTO, Professor.class);
        return Mapper.parseObject(repository.save(professor), ProfessorDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one person");

        Professor professor = Mapper.parseObject(findById(id), Professor.class);

        repository.delete(professor);
    }

}
