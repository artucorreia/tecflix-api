package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, UUID> {
}
