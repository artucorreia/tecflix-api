package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.BankAccountDTO;
import com.artur.tecflix_api.data.DTO.v1.ProfessorDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.BankAccount;
import com.artur.tecflix_api.model.Professor;
import com.artur.tecflix_api.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class BankAccountService {
    Logger logger = Logger.getLogger(BankAccountService.class.getName());

    @Autowired
    private BankAccountRepository repository;

    @Autowired
    private ProfessorService professorService;

    public BankAccountDTO findById(UUID id) {
        logger.info("finding one bank account");

        return Mapper.parseObject(
                repository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No records found for this id")
                        ),
                BankAccountDTO.class
        );
    }

    public List<BankAccountDTO> findAll() {
        logger.info("finding all bank accounts");

        return Mapper.parseObjectList(repository.findAll(), BankAccountDTO.class);
    }

    public BankAccountDTO create(BankAccountDTO bankAccountDTO) {
        logger.info("creating one bank account");

        BankAccount entity = Mapper.parseObject(bankAccountDTO, BankAccount.class);
        entity.setProfessor(
                Mapper.parseObject(
                        professorService.findById(bankAccountDTO.getProfessorId()),
                        Professor.class
                )
        );

        return Mapper.parseObject(repository.save(entity), BankAccountDTO.class);
    }
}
