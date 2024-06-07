package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OccupationRepository extends JpaRepository<Occupation, UUID> {
}
