package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "address")
public class Address implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 100)
    private String state;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 150)
    private String street;

    @Column(nullable = false, length = 150)
    private String complement;

    @Column(nullable = false, length = 150)
    private String neighborhood;

    @OneToOne @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = false)
    private Professor professor;

    public Address() {}

    public Address(UUID id, String cep, String state, String city, String street, String complement, String neighborhood, Professor professor) {
        this.id = id;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.professor = professor;
    }

    public UUID getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id)
                && Objects.equals(cep, address.cep)
                && Objects.equals(state, address.state)
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street)
                && Objects.equals(complement, address.complement)
                && Objects.equals(neighborhood, address.neighborhood)
                && Objects.equals(professor, address.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, state, city, street, complement, neighborhood, professor);
    }
}
