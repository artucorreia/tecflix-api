package com.artur.tecflix_api.data.DTO.v1;

import com.artur.tecflix_api.enums.PaymentMethod;
import com.artur.tecflix_api.enums.PaymentStatus;

import java.util.Objects;
import java.util.UUID;

public class PaymentDTO {
    private UUID id;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private UserDTO user;
    private CourseDTO course;

    public PaymentDTO() {}

    public PaymentDTO(UUID id, PaymentMethod paymentMethod, PaymentStatus paymentStatus, UserDTO user, CourseDTO course) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.user = user;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public UserDTO getUser() {
        return user;
    }

    public CourseDTO getCourse() {
        return course;
    }
}
