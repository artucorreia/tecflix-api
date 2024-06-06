package com.artur.tecflix_api.data.DTO.v1;

import java.util.Objects;
import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String fullName;
    private String email;
    private String password;
    private Boolean active;

    public UserDTO() {}

    public UserDTO(UUID id, String fullName, String email, String password, Boolean active) {
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
}
