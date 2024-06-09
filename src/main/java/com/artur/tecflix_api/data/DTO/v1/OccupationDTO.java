package com.artur.tecflix_api.data.DTO.v1;

import java.util.UUID;

public class OccupationDTO {
    private UUID id;
    private String name;

    public OccupationDTO() {}

    public OccupationDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}