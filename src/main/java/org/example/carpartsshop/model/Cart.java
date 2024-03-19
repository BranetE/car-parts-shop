package org.example.carpartsshop.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ElementCollection
    private List<OrderProduct> products;

    public void addProduct(OrderProduct product){
        products.add(product);
    }

    public void removeProduct(OrderProduct product){
        products.remove(product);
    }

}
