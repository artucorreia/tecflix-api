package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.ClassDTO;
import com.artur.tecflix_api.data.DTO.v1.CourseDTO;
import com.artur.tecflix_api.data.DTO.v1.ModuleDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Module;
import com.artur.tecflix_api.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ModuleService {
    Logger logger = Logger.getLogger(ModuleService.class.getName());

    @Autowired
    private ModuleRepository repository;

    @Autowired
    private CourseService courseService;

    public ModuleDTO findById(UUID id) {
        logger.info("finding one module");

        return Mapper.parseObject(
                repository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No records found for this id")
                        ),
                ModuleDTO.class
        );
    }

    public List<ModuleDTO> findAll() {
        logger.info("finding all modules");

        return Mapper.parseObjectList(repository.findAll(), ModuleDTO.class);
    }

    public ModuleDTO create(ModuleDTO moduleDTO) {
        logger.info("creating one module");

        Module entity = Mapper.parseObject(moduleDTO, Module.class);

        return Mapper.parseObject(repository.save(entity), ModuleDTO.class);
    }
}
