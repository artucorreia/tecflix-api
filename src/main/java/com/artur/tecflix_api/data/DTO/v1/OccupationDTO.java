package com.artur.tecflix_api.data.DTO.v1;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OccupationDTO {
    private UUID id;
    private String name;
    private List<ProfessorDTO> professors;

    public OccupationDTO() {}

    public OccupationDTO(UUID id, String name, List<ProfessorDTO> professors) {
        this.id = id;
        this.name = name;
        this.professors = professors;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProfessorDTO> getProfessors() {
        return professors;
    }
}
