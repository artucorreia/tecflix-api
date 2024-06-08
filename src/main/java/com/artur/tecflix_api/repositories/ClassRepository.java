package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClassRepository extends JpaRepository<Class, UUID> {
}
