package com.artur.tecflix_api.controller;

import com.artur.tecflix_api.data.DTO.v1.CreditCardDTO;
import com.artur.tecflix_api.data.DTO.v1.UserDTO;
import com.artur.tecflix_api.services.CreditCardService;
import com.artur.tecflix_api.services.PaymentService;
import com.artur.tecflix_api.services.RatingService;
import com.artur.tecflix_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CreditCardService creditCardService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    RatingService ratingService;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO findById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO create(@RequestBody UserDTO user) {
        return userService.create(user);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO update(@RequestBody UserDTO user) {
        return userService.update(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(
            value = "/{id}/credit_cards",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<CreditCardDTO> findAllCreditCards(@PathVariable UUID id) {
        UserDTO userDTO = userService.findById(id);
        return userDTO.getCreditCards();
    }
}
