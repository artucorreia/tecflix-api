package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ModuleDTO {
    private UUID id;
    private String title;
    private LocalTime moduleDuration;
    private UUID courseId;
    private List<ClassDTO> classes;

    public ModuleDTO() {}

    public ModuleDTO(UUID id, String title, LocalTime moduleDuration, UUID courseId, List<ClassDTO> classes) {
        this.id = id;
        this.title = title;
        this.moduleDuration = moduleDuration;
        this.courseId = courseId;
        this.classes = classes;
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

    public LocalTime getModuleDuration() {
        return moduleDuration;
    }

    public void setModuleDuration(LocalTime moduleDuration) {
        this.moduleDuration = moduleDuration;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public List<ClassDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassDTO> classes) {
        this.classes = classes;
    }
}
