package com.dryfruits.backenddryfruits.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCT_VARIETY")
public class ProductVariety {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int productId;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Image URL is required")
    private String imageUrl;

    @Min(value = 1, message = "Actual price must be greater than 0")
    private int actualPrice;
    @Min(value = 0, message = "Discount price cannot be negative")
    private int discountPrice;
    private int finalPrice;

    @Min(value = 1, message = "Unit must be at least 1")
    private int unit;

    @NotBlank(message = "Unit type is required")
    private String unitType;

    private double rating;
    private int sold;

    private String quality;

    @ElementCollection
    @CollectionTable(name = "PRODUCT_VARIETY_BENEFITS",
            joinColumns = @JoinColumn(name = "product_variety_id"))
    private List<Benefits> productBenefits;

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

