package com.artur.tecflix_api.data.DTO.v1;

import java.util.UUID;

public class SocialDTO {
    private UUID id;
    private String url;
    private UUID professorId;

    public SocialDTO() {}

    public SocialDTO(UUID id, String url, UUID professorId) {
        this.id = id;
        this.url = url;
        this.professorId = professorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UUID getProfessorId() {
        return professorId;
    }

    public void setProfessorId(UUID professorId) {
        this.professorId = professorId;
    }
}