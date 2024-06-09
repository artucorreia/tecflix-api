package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.CreditCardDTO;
import com.artur.tecflix_api.data.DTO.v1.UserDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.CreditCard;
import com.artur.tecflix_api.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class CreditCardService {
    private final Logger logger = Logger.getLogger(CreditCardService.class.getName());

    @Autowired
    private CreditCardRepository repository;

    @Autowired
    private UserService userService;

    public CreditCardDTO findById(UUID id) {
        logger.info("Finding one credit card");

        return Mapper.parseObject(
                repository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("No records found for this id")
                ),
                CreditCardDTO.class
        );
    }

    public List<CreditCardDTO> findAll() {
        logger.info("Finding all credit cards");

        return Mapper.parseObjectList(repository.findAll(), CreditCardDTO.class);
    }

    public CreditCardDTO create(CreditCardDTO creditCardDTO) {
        logger.info("Creating one credit card");

        UserDTO userDTO = userService.findById(creditCardDTO.getUser().getId());
        creditCardDTO.setUser(userDTO);

        return Mapper.parseObject(creditCardDTO, CreditCardDTO.class);
    }

    public CreditCardDTO update(CreditCardDTO creditCardDTO) {
        logger.info("Updating one credit card");

        CreditCard creditCard = Mapper.parseObject(findById(creditCardDTO.getId()), CreditCard.class);
        creditCard.setCardNumber(creditCardDTO.getCardNumber());
        creditCard.setCardHolder(creditCardDTO.getCardHolder());
        creditCard.setCvv(creditCardDTO.getCvv());
        creditCard.setExpirationDate(creditCardDTO.getExpirationDate());

        return Mapper.parseObject(repository.save(creditCard), CreditCardDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one person");

        CreditCard creditCard = Mapper.parseObject(findById(id), CreditCard.class);

        repository.delete(creditCard);
    }
}
