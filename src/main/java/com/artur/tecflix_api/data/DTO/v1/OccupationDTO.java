package com.artur.tecflix_api.data.DTO.v1;

import java.util.UUID;

public class OccupationDTO {
    private UUID id;
    private String name;
//    private List<ProfessorDTO> professors;

    public OccupationDTO() {}

    public OccupationDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
//        this.professors = professors;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public List<ProfessorDTO> getProfessors() {
//        return professors;
//    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setProfessors(List<ProfessorDTO> professors) {
//        this.professors = professors;
//    }

    @Override
    public String toString() {
        return "OccupationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
