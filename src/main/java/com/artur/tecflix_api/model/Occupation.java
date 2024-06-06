package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Table
@Entity(name = "Occupation")
public class Occupation {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

    @OneToMany(mappedBy = "occupation")
    private List<Professor> professors;

    public Occupation() {}

    public Occupation(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Professor> getProfessors() {
        return professors;
    }
}
