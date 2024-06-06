package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "course")
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(name = "course_duration", nullable = false)
    private LocalTime courseDuration;

    @Column(name = "image_cape", nullable = false)
    private String imageCape;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = false)
    private Professor professor;

    @OneToMany(mappedBy = "course")
    private List<Module> modules;

    @OneToMany(mappedBy = "course")
    private List<Payment> payments;

    public Course() {}

    public Course(UUID id, String title, LocalTime courseDuration, String imageCape, String description, Professor professor) {
        this.id = id;
        this.title = title;
        this.courseDuration = courseDuration;
        this.imageCape = imageCape;
        this.description = description;
        this.professor = professor;
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

    public Professor getProfessor() {
        return professor;
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id)
                && Objects.equals(title, course.title)
                && Objects.equals(courseDuration, course.courseDuration)
                && Objects.equals(imageCape, course.imageCape)
                && Objects.equals(description, course.description)
                && Objects.equals(professor, course.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, courseDuration, imageCape, description, professor);
    }
}
