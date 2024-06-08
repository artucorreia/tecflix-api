package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class RatingDTO {
    private UUID id;
    private Double grade;
    private String comment;
    private LocalTime dateTime;
    private UserDTO user;
    private CourseDTO course;

    public RatingDTO() {}

    public RatingDTO(UUID id, Double grade, String comment, LocalTime dateTime, UserDTO user, CourseDTO course) {
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

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalTime dateTime) {
        this.dateTime = dateTime;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
