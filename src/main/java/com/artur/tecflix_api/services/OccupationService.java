package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.OccupationDTO;
import com.artur.tecflix_api.data.DTO.v1.ProfessorDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Occupation;
import com.artur.tecflix_api.repositories.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class OccupationService {
    Logger logger = Logger.getLogger(OccupationService.class.getName());

    @Autowired
    private OccupationRepository repository;

    public OccupationDTO findById(UUID id) {
        logger.info("finding one occupation");

        return Mapper.parseObject(
                repository.findById(id)
                        .orElseThrow(
                            () -> new ResourceNotFoundException("No records found for this id")
                        ),
                OccupationDTO.class
        );
    }

    public List<OccupationDTO> findAll() {
        logger.info("finding all occupations");

        return Mapper.parseObjectList(repository.findAll(), OccupationDTO.class);
    }

    public OccupationDTO create(OccupationDTO occupationDTO) {
        logger.info("creating one occupation");
        logger.info(occupationDTO.toString());

        Occupation entity = Mapper.parseObject(occupationDTO, Occupation.class);

        return Mapper.parseObject(repository.save(entity), OccupationDTO.class);
    }

//    public OccupationDTO addProfessor(UUID occupationId, ProfessorDTO professorDTO) {
//        OccupationDTO occupationDTO = findById(occupationId);
//
//        occupationDTO.getProfessors().add(professorDTO);
//
//        Occupation entity = Mapper.parseObject(occupationDTO, Occupation.class);
//
//        return Mapper.parseObject(repository.save(entity), OccupationDTO.class);
//    }
}
