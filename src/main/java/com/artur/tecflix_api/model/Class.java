package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "class")
public class Class {
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
