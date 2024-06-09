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
    private UUID professorId;

    public CourseDTO() {}

    public CourseDTO(UUID id, String title, LocalTime courseDuration, String imageCape, String description, List<ModuleDTO> modules, UUID professorId) {
        this.id = id;
        this.title = title;
        this.courseDuration = courseDuration;
        this.imageCape = imageCape;
        this.description = description;
        this.modules = modules;
        this.professorId = professorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(LocalTime courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getImageCape() {
        return imageCape;
    }

    public void setImageCape(String imageCape) {
        this.imageCape = imageCape;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ModuleDTO> getModules() {
        return modules;
    }

    public void setModules(List<ModuleDTO> modules) {
        this.modules = modules;
    }

    public UUID getProfessorId() {
        return professorId;
    }

    public void setProfessorId(UUID professorId) {
        this.professorId = professorId;
    }
}
