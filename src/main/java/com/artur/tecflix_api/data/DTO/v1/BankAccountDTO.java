package com.artur.tecflix_api.data.DTO.v1;

import java.util.UUID;

public class BankAccountDTO {
    private UUID id;
    private String agency;
    private String accountNumber;
    private String dv;
    private UUID professorId;

    public BankAccountDTO() {}

    public BankAccountDTO(UUID id, String agency, String accountNumber, String dv, UUID professorId) {
        this.id = id;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.dv = dv;
        this.professorId = professorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public UUID getProfessorId() {
        return professorId;
    }

    public void setProfessorId(UUID professorId) {
        this.professorId = professorId;
    }
}
