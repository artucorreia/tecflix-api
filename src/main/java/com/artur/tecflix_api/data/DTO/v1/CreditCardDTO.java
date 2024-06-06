package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalTime;
import java.util.UUID;

public class CreditCardDTO {
    private UUID id;
    private String cardNumber;
    private LocalTime expirationDate;
    private String cvv;
    private UserDTO user;

    public CreditCardDTO() {}

    public CreditCardDTO(UUID id, String cardNumber, LocalTime expirationDate, String cvv, UserDTO user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalTime getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public UserDTO getUser() {
        return user;
    }
}
