package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "Rating")
public class Rating implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "grade", nullable = false)
    private Double grade;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;

    public Rating() {}

    public Rating(UUID id, Double grade, String comment, LocalDateTime dateTime, User user, Course course) {
        this.id = id;
        this.grade = grade;
        this.comment = comment;
        this.dateTime = dateTime;
        this.user = user;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public Double getGrade() {
        return grade;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(id, rating.id)
                && Objects.equals(grade, rating.grade)
                && Objects.equals(comment, rating.comment)
                && Objects.equals(dateTime, rating.dateTime)
                && Objects.equals(user, rating.user)
                && Objects.equals(course, rating.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grade, comment, dateTime, user, course);
    }
}
