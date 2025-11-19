package com.dryfruits.backenddryfruits.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Product ID is required")
    private Integer productId;

    @NotNull(message = "Product variety ID is required")
    private Integer productVarietyId;

    @Min(value = 1, message = "Price must be at least 1")
    private int price;

    @Min(value = 1, message = "Unit must be at least 1")
    private int unit;

    @NotBlank(message = "Unit type is required")
    private String unitType;

    @NotBlank(message = "Payment type is required")
    private String paymentType;  // COD, UPI, Card, NetBanking

    private String paymentStatus = "PENDING"; // PAID, FAILED, REFUND

    private String orderStatus = "PLACED"; // PLACED, SHIPPED, OUT_FOR_DELIVERY, DELIVERED, CANCELLED

    // Use java.util.Date + Temporal + explicit columnDefinition to get `datetime` (no (6))
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date_and_time", columnDefinition = "datetime")
    private Date orderDateAndTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delivery_date", columnDefinition = "datetime")
    private Date deliveryDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delivered_date_and_time", columnDefinition = "datetime")
    private Date deliveredDateAndTime;

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

