package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.CourseDTO;
import com.artur.tecflix_api.data.DTO.v1.RatingDTO;
import com.artur.tecflix_api.data.DTO.v1.UserDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.Rating;
import com.artur.tecflix_api.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class RatingService {
    private final Logger logger = Logger.getLogger(RatingService.class.getName());

    @Autowired
    RatingRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    public RatingDTO findById(UUID id) {
        logger.info("Finding one rating");

        return Mapper.parseObject(
                repository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("No records found for this id")
                ),
                RatingDTO.class
        );
    }

    public List<RatingDTO> findAll() {
        logger.info("Finding all ratings");

        return Mapper.parseObjectList(repository.findAll(), RatingDTO.class);
    }

    public RatingDTO create(RatingDTO ratingDTO, UUID courseId, UUID userId) {
        logger.info("Creating one rating");

        UserDTO userDTO = userService.findById(userId);
        ratingDTO.setUser(userDTO);

        CourseDTO courseDTO = courseService.findById(courseId);
        ratingDTO.setCourse(courseDTO);

        Rating rating = Mapper.parseObject(ratingDTO, Rating.class);
        return Mapper.parseObject(repository.save(rating), RatingDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one rating");

        Rating rating = Mapper.parseObject(findById(id), Rating.class);

        repository.delete(rating);
    }
}
