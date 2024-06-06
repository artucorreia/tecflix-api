package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "bank_account")
public class BankAccount {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 5)
    private String agency;

    @Column(nullable = false, length = 12, unique = true)
    private String accountNumber;

    @Column(nullable = false, length = 1)
    private String dv;

    @OneToOne @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = false)
    private Professor professor;

    public BankAccount() {}

    public BankAccount(UUID id, String agency, String accountNumber, String dv, Professor professor) {
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

    public Professor getProfessor() {
        return professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id)
                && Objects.equals(agency, that.agency)
                && Objects.equals(accountNumber, that.accountNumber)
                && Objects.equals(dv, that.dv)
                && Objects.equals(professor, that.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agency, accountNumber, dv, professor);
    }
}
