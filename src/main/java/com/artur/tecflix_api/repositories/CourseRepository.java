package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<Course> findByProfessorId(UUID professorId);
    Optional<Course> findByIdAndProfessorId(UUID courseId, UUID professorId);
}
