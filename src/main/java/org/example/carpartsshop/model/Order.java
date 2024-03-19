package org.example.carpartsshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private OrderStatus status;
    @ElementCollection
    private List<OrderProduct> products;
    @Formula(value = "select sum(p.price * op.quantity) from order_products op join products p on op.product_id = p.id where op.order_id = id")
    private Long totalPrice;
    @Column
    private String deliveryAddress;
    @Column
    private Boolean isPaid = false;
}
