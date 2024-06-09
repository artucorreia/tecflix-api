package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class CourseDTO {
    private UUID id;
    private String title;
    private LocalTime courseDuration;
    private String imageCape;
    private String description;
    private List<ModuleDTO> modules;
    private ProfessorDTO professor;

    public CourseDTO() {}

    public CourseDTO(
            UUID id,
            String title,
            LocalTime courseDuration,
            String imageCape,
            String description,
            ProfessorDTO professor,
            List<ModuleDTO> modules
    ) {
        this.id = id;
        this.title = title;
        this.courseDuration = courseDuration;
        this.imageCape = imageCape;
        this.description = description;
        this.professor = professor;
        this.modules = modules;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalTime getCourseDuration() {
        return courseDuration;
    }

    public String getImageCape() {
        return imageCape;
    }

    public String getDescription() {
        return description;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public List<ModuleDTO> getModules() {
        return modules;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourseDuration(LocalTime courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void setImageCape(String imageCape) {
        this.imageCape = imageCape;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public void setModules(List<ModuleDTO> modules) {
        this.modules = modules;
    }
}
