package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class ClassDTO {
    private UUID id;
    private String title;
    private LocalTime classDuration;
    private String video;

    public ClassDTO() {}

    public ClassDTO(UUID id, String title, LocalTime classDuration, String video) {
        this.id = id;
        this.title = title;
        this.classDuration = classDuration;
        this.video = video;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalTime getClassDuration() {
        return classDuration;
    }

    public String getVideo() {
        return video;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassDTO classDTO = (ClassDTO) o;
        return Objects.equals(id, classDTO.id) && Objects.equals(title, classDTO.title) && Objects.equals(classDuration, classDTO.classDuration) && Objects.equals(video, classDTO.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, classDuration, video);
    }
}
