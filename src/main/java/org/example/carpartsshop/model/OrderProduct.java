package org.example.carpartsshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class OrderProduct {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column
    private Long quantity;
    @Column
    private Double totalPrice;
}
