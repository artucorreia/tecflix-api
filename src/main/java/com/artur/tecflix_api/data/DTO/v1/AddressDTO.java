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
    private ProfessorDTO professor;

    public AddressDTO() {}

    public AddressDTO(
            UUID id,
            String cep,
            String state,
            String city,
            String street,
            String complement,
            String neighborhood,
            ProfessorDTO professor
    ) {
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

    public ProfessorDTO getProfessor() {
        return professor;
    }
}
