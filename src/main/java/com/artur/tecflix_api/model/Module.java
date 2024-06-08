package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "Module")
public class Module implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(name = "module_duration", nullable = false)
    private LocalTime moduleDuration;

    @ManyToOne @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "module", fetch = FetchType.EAGER)
    private List<Class> classes;

    public Module() {}

    public Module(UUID id, String title, LocalTime moduleDuration, Course course) {
        this.id = id;
        this.title = title;
        this.moduleDuration = moduleDuration;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public List<Class> getClasses() {
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

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(id, module.id)
                && Objects.equals(title, module.title)
                && Objects.equals(moduleDuration, module.moduleDuration)
                && Objects.equals(course, module.course)
                && Objects.equals(classes, module.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, moduleDuration, course, classes);
    }
}
