package com.artur.tecflix_api.data.DTO.v1;

import com.artur.tecflix_api.enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProfessorDTO {
    private UUID id;
    private UserDTO user;
    private String biography;
    private LocalDate birthdate;
    private Gender gender;
    private String cpf;
    private String contact;
    private Boolean active;
    private OccupationDTO occupation;
    private AddressDTO address;
    private BankAccountDTO bankAccount;
    private List<SocialDTO> socialList;
    private List<CourseDTO> courses;

    public ProfessorDTO() {}

    public ProfessorDTO(
            UUID id,
            UserDTO user,
            String biography,
            LocalDate birthdate,
            Gender gender,
            String cpf,
            String contact,
            Boolean active,
            OccupationDTO occupation,
            AddressDTO address,
            BankAccountDTO bankAccount,
            List<SocialDTO> socialList,
            List<CourseDTO> courses
    ) {
        this.id = id;
        this.user = user;
        this.biography = biography;
        this.birthdate = birthdate;
        this.gender = gender;
        this.cpf = cpf;
        this.contact = contact;
        this.active = active;
        this.occupation = occupation;
        this.address = address;
        this.bankAccount = bankAccount;
        this.socialList = socialList;
        this.courses = courses;
    }

    public UUID getId() {
        return id;
    }

    public UserDTO getUser() {
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

    public OccupationDTO getOccupation() {
        return occupation;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public BankAccountDTO getBankAccount() {
        return bankAccount;
    }

    public List<SocialDTO> getSocialList() {
        return socialList;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setOccupation(OccupationDTO occupation) {
        this.occupation = occupation;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public void setBankAccount(BankAccountDTO bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setSocialList(List<SocialDTO> socialList) {
        this.socialList = socialList;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
