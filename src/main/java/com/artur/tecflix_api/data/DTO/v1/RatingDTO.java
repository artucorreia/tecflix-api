package com.artur.tecflix_api.data.DTO.v1;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class RatingDTO {
    private UUID id;
    private Double grade;
    private String comment;
    private LocalTime dateTime;
    private UUID userId;
    private UUID courseId;

    public RatingDTO() {}

    public RatingDTO(UUID id, Double grade, String comment, LocalTime dateTime, UUID userId, UUID courseId) {
        this.id = id;
        this.grade = grade;
        this.comment = comment;
        this.dateTime = dateTime;
        this.userId = userId;
        this.courseId = courseId;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
}
