package org.mycompany.servimark.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "departaments")
public class Departament {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false) 
        Short id;
        @Column(name = "name", nullable = false)
        String name;
        @Column(name = "created_at") 
        Instant createdAt;
        @Column(name = "updated_at") Instant 
        updatedAt;

        // Getter and Setter methods for id
        public Short getId() {
            return id;
        }

        public void setId(Short id) {
            this.id = id;
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
}
