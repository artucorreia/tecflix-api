package com.artur.tecflix_api.data.DTO.v1;

import java.util.UUID;

public class AddressDTO {
    private UUID id;
    private String cep;
    private String state;
    private String city;
    private String street;
    private String complement;
    private String neighborhood;
    private UUID professorId;

    public AddressDTO() {}

    public AddressDTO(UUID id, String cep, String state, String city, String street, String complement, String neighborhood, UUID professorId) {
        this.id = id;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.professorId = professorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public UUID getProfessorId() {
        return professorId;
    }

    public void setProfessorId(UUID professorId) {
        this.professorId = professorId;
    }
}
