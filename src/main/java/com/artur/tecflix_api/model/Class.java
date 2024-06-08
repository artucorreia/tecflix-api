package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "class")
public class Class implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 60)
    private String title;

    @Column(nullable = false)
    private LocalTime classDuration;

    @Column(nullable = false)
    private String video;

    @ManyToOne @JoinColumn(name = "module_id", referencedColumnName = "id", nullable = false)
    private Module module;

    public Class() {}

    public Class(UUID id, String title, LocalTime classDuration, String video, Module module) {
        this.id = id;
        this.title = title;
        this.classDuration = classDuration;
        this.video = video;
        this.module = module;
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

    public Module getModule() {
        return module;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClassDuration(LocalTime classDuration) {
        this.classDuration = classDuration;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(id, aClass.id)
                && Objects.equals(title, aClass.title)
                && Objects.equals(classDuration, aClass.classDuration)
                && Objects.equals(video, aClass.video)
                && Objects.equals(module, aClass.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, classDuration, video, module);
    }
}
