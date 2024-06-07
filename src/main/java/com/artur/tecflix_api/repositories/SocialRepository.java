package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Social;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialRepository extends JpaRepository<Social, UUID> {
}
