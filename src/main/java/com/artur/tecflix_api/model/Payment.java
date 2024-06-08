package com.artur.tecflix_api.model;

import com.artur.tecflix_api.enums.PaymentMethod;
import com.artur.tecflix_api.enums.PaymentStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "Payment")
public class Payment implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    @ManyToOne @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;

    public Payment() {}

    public Payment(UUID id, PaymentMethod paymentMethod, PaymentStatus paymentStatus, User user, Course course) {
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

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
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
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id)
                && Objects.equals(paymentMethod, payment.paymentMethod)
                && paymentStatus == payment.paymentStatus
                && Objects.equals(user, payment.user)
                && Objects.equals(course, payment.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentMethod, paymentStatus, user, course);
    }
}
