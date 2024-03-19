package org.example.carpartsshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

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
    @Formula(value = "select p.price * quantity from product p where p.id = product_id")
    private Double totalPrice;
}
