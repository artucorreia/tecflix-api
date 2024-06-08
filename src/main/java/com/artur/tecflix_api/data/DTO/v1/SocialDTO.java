package com.artur.tecflix_api.data.DTO.v1;

import java.util.Objects;
import java.util.UUID;

public class SocialDTO {
    private UUID id;
    private String url;
    private ProfessorDTO professor;

    public SocialDTO() {}

    public SocialDTO(UUID id, String url, ProfessorDTO professor) {
        this.id = id;
        this.url = url;
        this.professor = professor;
    }

    public UUID getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }
}
