package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.PaymentDTO;
import com.artur.tecflix_api.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PaymentDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PaymentDTO create(@RequestBody PaymentDTO paymentDTO) {
        return service.create(paymentDTO);
    }
}
