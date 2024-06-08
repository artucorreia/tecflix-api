package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class ClassDTO {
    private UUID id;
    private String title;
    private LocalTime classDuration;
    private String video;
    private ModuleDTO module;

    public ClassDTO() {}

    public ClassDTO(UUID id, String title, LocalTime classDuration, String video, ModuleDTO module) {
        this.id = id;
        this.title = title;
        this.classDuration = classDuration;
        this.video = video;
        this.module = module;
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

    public LocalTime getClassDuration() {
        return classDuration;
    }

    public void setClassDuration(LocalTime classDuration) {
        this.classDuration = classDuration;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public ModuleDTO getModule() {
        return module;
    }

    public void setModule(ModuleDTO module) {
        this.module = module;
    }
}
