package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Table
@Entity(name = "Occupation")
public class Occupation implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

    @OneToMany(mappedBy = "occupation", fetch = FetchType.EAGER)
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
}
