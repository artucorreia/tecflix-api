package com.artur.tecflix_api.data.DTO.v1;

import java.util.List;
import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String fullName;
    private String email;
    private String password;
    private Boolean active;
    private List<CreditCardDTO> creditCards;
    private List<RatingDTO> ratings;
    private List<PaymentDTO> payments;

    public UserDTO() {}

    public UserDTO(UUID id, String fullName, String email, String password, Boolean active, List<CreditCardDTO> creditCards, List<RatingDTO> ratings, List<PaymentDTO> payments) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.active = active;
        this.creditCards = creditCards;
        this.ratings = ratings;
        this.payments = payments;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<CreditCardDTO> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCardDTO> creditCards) {
        this.creditCards = creditCards;
    }

    public List<RatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }

    public List<PaymentDTO> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDTO> payments) {
        this.payments = payments;
    }
}
