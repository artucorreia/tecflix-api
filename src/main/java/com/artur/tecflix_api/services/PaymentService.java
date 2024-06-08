package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.CourseDTO;
import com.artur.tecflix_api.data.DTO.v1.PaymentDTO;
import com.artur.tecflix_api.data.DTO.v1.UserDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Payment;
import com.artur.tecflix_api.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class PaymentService {
    private final Logger logger = Logger.getLogger(PaymentService.class.getName());

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    public PaymentDTO findById(UUID id) {
        logger.info("Finding one payment");

        return Mapper.parseObject(
                paymentRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("No records found for this id")
                ),
                PaymentDTO.class
        );
    }

    public List<PaymentDTO> findAll() {
        logger.info("Finding all payments");

        return Mapper.parseObjectList(paymentRepository.findAll(), PaymentDTO.class);
    }

    public PaymentDTO create(PaymentDTO paymentDTO, UUID courseId, UUID userId) {
        logger.info("Creating one payment");

        UserDTO userDTO = userService.findById(userId);
        paymentDTO.setUser(userDTO);

        CourseDTO courseDTO = courseService.findById(courseId);
        paymentDTO.setCourse(courseDTO);

        Payment payment = Mapper.parseObject(paymentDTO, Payment.class);
        return Mapper.parseObject(paymentRepository.save(payment), PaymentDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one payment");

        Payment payment = Mapper.parseObject(findById(id), Payment.class);

        paymentRepository.delete(payment);
    }
}