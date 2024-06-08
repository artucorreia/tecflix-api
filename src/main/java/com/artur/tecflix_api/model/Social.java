package com.artur.tecflix_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "Social")
public class Social implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String url;

    @ManyToOne @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    public Social() {}

    public Social(UUID id, String url, Professor professor) {
        this.id = id;
        this.url = url;
        this.professor = professor;
    }

    public UUID getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Social social = (Social) o;
        return Objects.equals(id, social.id)
                && Objects.equals(url, social.url)
                && Objects.equals(professor, social.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, professor);
    }
}
