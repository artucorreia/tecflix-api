package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
