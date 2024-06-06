package com.artur.tecflix_api.model;

import com.artur.tecflix_api.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Table
@Entity(name = "Professor")
public class Professor {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String biography;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, length = 11, unique = true)
    private String contact;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne @JoinColumn(name = "occupation_id", nullable = false)
    private Occupation occupation;

    @OneToOne(mappedBy = "professor")
    private Address address;

    @OneToOne(mappedBy = "professor")
    private BankAccount bankAccount;

    @OneToMany(mappedBy = "professor")
    private List<Social> socials;

    @OneToMany(mappedBy = "professor")
    private List<Course> courses;

    public Professor() {}

    public Professor(UUID id, User user, String biography, LocalDate birthdate, Gender gender, String cpf, String contact, Boolean active, Occupation occupation) {
        this.id = id;
        this.user = user;
        this.biography = biography;
        this.birthdate = birthdate;
        this.gender = gender;
        this.cpf = cpf;
        this.contact = contact;
        this.active = active;
        this.occupation = occupation;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getBiography() {
        return biography;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContact() {
        return contact;
    }

    public Boolean getActive() {
        return active;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public Address getAddress() {
        return address;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public List<Social> getSocials() {
        return socials;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id)
                && Objects.equals(user, professor.user)
                && Objects.equals(biography, professor.biography)
                && Objects.equals(birthdate, professor.birthdate)
                && gender == professor.gender
                && Objects.equals(cpf, professor.cpf)
                && Objects.equals(contact, professor.contact)
                && Objects.equals(active, professor.active)
                && Objects.equals(occupation, professor.occupation)
                && Objects.equals(address, professor.address)
                && Objects.equals(bankAccount, professor.bankAccount)
                && Objects.equals(socials, professor.socials)
                && Objects.equals(courses, professor.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                user,
                biography,
                birthdate,
                gender,
                cpf,
                contact,
                active,
                occupation,
                address,
                bankAccount,
                socials,
                courses
        );
    }
}
