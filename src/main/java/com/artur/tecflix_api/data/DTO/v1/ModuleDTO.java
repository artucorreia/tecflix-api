package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ModuleDTO {
    private UUID id;
    private String title;
    private LocalTime moduleDuration;
    private CourseDTO course;
    private List<ClassDTO> classes;

    public ModuleDTO() {}

    public ModuleDTO(
            UUID id,
            String title,
            LocalTime moduleDuration,
            CourseDTO course,
            List<ClassDTO> classes
    ) {
        this.id = id;
        this.title = title;
        this.moduleDuration = moduleDuration;
        this.course = course;
        this.classes = classes;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalTime getModuleDuration() {
        return moduleDuration;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public List<ClassDTO> getClasses() {
        return classes;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setModuleDuration(LocalTime moduleDuration) {
        this.moduleDuration = moduleDuration;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public void setClasses(List<ClassDTO> classes) {
        this.classes = classes;
    }
}
