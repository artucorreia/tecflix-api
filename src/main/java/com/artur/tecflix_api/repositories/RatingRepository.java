package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RatingRepository extends JpaRepository<Rating, UUID> {
}
