package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "credit_card")
public class CreditCard implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "card_holder", nullable = false, length = 100)
    private String cardHolder;

    @Column(name = "card_number", nullable = false, length = 20, unique = true)
    private String cardNumber;

    @Column(name = "cvv", nullable = false, length = 3)
    private String cvv;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @ManyToOne @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public CreditCard() {}

    public CreditCard(UUID id, String cardHolder, String cardNumber, String cvv, LocalDate expirationDate, User user) {
        this.id = id;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public User getUser() {
        return user;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(id, that.id)
                && Objects.equals(cardNumber, that.cardNumber)
                && Objects.equals(cvv, that.cvv)
                && Objects.equals(expirationDate, that.expirationDate)
                && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cvv, expirationDate, user);
    }
}
