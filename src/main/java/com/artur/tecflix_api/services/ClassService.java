package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.ClassDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Class;
import com.artur.tecflix_api.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ClassService {
    Logger logger = Logger.getLogger(ClassService.class.getName());

    @Autowired
    private ClassRepository repository;

    public ClassDTO findById(UUID id) {
        logger.info("finding one class");

        return Mapper.parseObject(
                repository.findById(id)
                .orElseThrow(
                    () -> new ResourceNotFoundException("No records found for this id")
                ),
                ClassDTO.class
        );
    }

    public List<ClassDTO> findAll() {
        logger.info("finding all classes");

        return Mapper.parseObjectList(repository.findAll(), ClassDTO.class);
    }

    public ClassDTO create(ClassDTO classDTO) {
        logger.info("creating one class");

        Class entity = Mapper.parseObject(classDTO, Class.class);

        return Mapper.parseObject(repository.save(entity), ClassDTO.class);
    }
}
