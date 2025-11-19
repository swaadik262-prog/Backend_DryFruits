package com.dryfruits.backenddryfruits.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;

    private int productId;

    private int productVarietyId;

    private String name;

    private String image;

    private double rating;

    private int unit;

    private String unitType;

    private int beforeDiscount;

    private int discount;

    private int afterDiscount;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate deliveryDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", columnDefinition = "datetime")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", columnDefinition = "datetime")
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at", columnDefinition = "datetime")
    private Date deletedAt;
}

