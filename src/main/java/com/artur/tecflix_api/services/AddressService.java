package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.AddressDTO;
import com.artur.tecflix_api.data.DTO.v1.ProfessorDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Address;
import com.artur.tecflix_api.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class AddressService {
    private final Logger logger = Logger.getLogger(AddressService.class.getName());

    @Autowired
    AddressRepository repository;

    @Autowired
    ProfessorService professorService;

    public AddressDTO findById(UUID id) {
        logger.info("Finding one address");

        return Mapper.parseObject(
                repository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("No records found for this id")
                ),
                AddressDTO.class
        );
    }

    public List<AddressDTO> findAll() {
        logger.info("Finding all address");

        return Mapper.parseObjectList(repository.findAll(), AddressDTO.class);
    }

    public AddressDTO create(AddressDTO addressDTO, UUID professorId) {
        logger.info("Creating one address");

        ProfessorDTO professorDTO = professorService.findById(professorId);
        addressDTO.setProfessor(professorDTO);

        Address address = Mapper.parseObject(addressDTO, Address.class);

        return Mapper.parseObject(repository.save(address), AddressDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one address");

        Address address = Mapper.parseObject(findById(id), Address.class);

        repository.delete(address);
    }
}