package org.mycompany.servimark.core.models;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "municipalities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    BigInteger id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departament_id", nullable = false)
    Departament departament;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "created_at")
    Instant createdAt;

    @Column(name = "updated_at")
    Instant updatedAt;

    public Municipality() {
    }

    // Getter and Setter methods for id
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    // Getter and Setter methods for departament
    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for createdAt
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    // Getter and Setter methods for updatedAt
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Municipality(String name) {
        this.name = name;
    }
}