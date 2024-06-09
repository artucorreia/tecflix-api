package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.BankAccountDTO;
import com.artur.tecflix_api.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/bank_accounts")
public class BackAccountController {
    @Autowired
    private BankAccountService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BankAccountDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccountDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BankAccountDTO create(@RequestBody BankAccountDTO bankAccountDTO) {
        return service.create(bankAccountDTO);
    }
}
