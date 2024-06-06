package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "User")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<CreditCard> creditCards;

    @OneToOne(mappedBy = "user")
    private Professor professor;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

    public User() {
    }

    public User(UUID id, String fullName, String email, String password, Boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(fullName, user.fullName)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(active, user.active)
                && Objects.equals(creditCards, user.creditCards)
                && Objects.equals(professor, user.professor)
                && Objects.equals(ratings, user.ratings)
                && Objects.equals(payments, user.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                fullName,
                email,
                password,
                active,
                creditCards,
                professor,
                ratings,
                payments
        );
    }
}
