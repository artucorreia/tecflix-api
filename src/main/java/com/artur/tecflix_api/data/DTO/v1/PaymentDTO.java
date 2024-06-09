package com.artur.tecflix_api.data.DTO.v1;

import com.artur.tecflix_api.enums.PaymentMethod;
import com.artur.tecflix_api.enums.PaymentStatus;

import java.util.Objects;
import java.util.UUID;

public class PaymentDTO {
    private UUID id;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private UUID userId;
    private UUID courseId;

    public PaymentDTO() {}

    public PaymentDTO(UUID id, PaymentMethod paymentMethod, PaymentStatus paymentStatus, UUID userId, UUID courseId) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.userId = userId;
        this.courseId = courseId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
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
