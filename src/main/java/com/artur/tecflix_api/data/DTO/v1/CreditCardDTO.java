package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalDate;
import java.util.UUID;

public class CreditCardDTO {
    private UUID id;
    private String cardNumber;
    private String cardHolder;
    private LocalDate expirationDate;
    private String cvv;
    private UserDTO user;

    public CreditCardDTO() {}

    public CreditCardDTO(UUID id, String cardNumber, String cardHolder, LocalDate expirationDate, String cvv, UserDTO user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
