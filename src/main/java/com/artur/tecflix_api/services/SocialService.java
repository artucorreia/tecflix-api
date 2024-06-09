package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.ProfessorDTO;
import com.artur.tecflix_api.data.DTO.v1.SocialDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Social;
import com.artur.tecflix_api.repositories.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class SocialService {
    Logger logger = Logger.getLogger(SocialService.class.getName());

    @Autowired
    private SocialRepository repository;

    @Autowired
    private ProfessorService professorService;

    public SocialDTO findById(UUID id) {
        logger.info("finding one course");

        return Mapper.parseObject(
                repository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No records found for this id")
                        ),
                SocialDTO.class
        );
    }

    public List<SocialDTO> findAll() {
        logger.info("finding all courses");

        return Mapper.parseObjectList(repository.findAll(), SocialDTO.class);
    }

    public SocialDTO create(SocialDTO classDTO, UUID professorId) {
        logger.info("creating one course");

        ProfessorDTO professorDTO = professorService.findById(professorId);
        classDTO.setProfessor(professorDTO);

        Social entity = Mapper.parseObject(classDTO, Social.class);

        return Mapper.parseObject(repository.save(entity), SocialDTO.class);
    }
}