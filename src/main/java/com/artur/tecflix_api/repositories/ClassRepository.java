package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassRepository extends JpaRepository<Class, UUID> {
}
