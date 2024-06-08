package com.artur.tecflix_api.data.DTO.v1;

import java.util.UUID;

public class BankAccountDTO {
    private UUID id;
    private String agency;
    private String accountNumber;
    private String dv;
    private ProfessorDTO professor;

    public BankAccountDTO() {}

    public BankAccountDTO(UUID id, String agency, String accountNumber, String dv, ProfessorDTO professor) {
        this.id = id;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.dv = dv;
        this.professor = professor;
    }

    public UUID getId() {
        return id;
    }

    public String getAgency() {
        return agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getDv() {
        return dv;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }
}
