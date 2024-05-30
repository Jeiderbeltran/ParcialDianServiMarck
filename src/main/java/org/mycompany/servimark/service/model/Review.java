package org.mycompany.servimark.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mycompany.servimark.user.model.User;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "rating", nullable = false, precision = 3, scale = 1)
    private BigDecimal rating;

    @Lob
    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}