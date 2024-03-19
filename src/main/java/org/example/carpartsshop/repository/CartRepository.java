package org.example.carpartsshop.repository;

import org.example.carpartsshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Modifying
    @Query(value = "INSERT INTO cart_products(cart_id, product_id, quantity) VALUES ((SELECT cart_id FROM carts WHERE user_id = :userId), :productId, 1)", nativeQuery = true)
    void addProduct(@Param("userId") Long userId, @Param("productId") Long productId);
    @Modifying
    @Query(value = "UPDATE cart_products SET quantity=:quantity WHERE cart_id = (SELECT cart_id FROM carts WHERE user_id = :userId) AND product_id = :productId", nativeQuery = true)
    void changeQuantity(@Param("userId") Long userId, @Param("productId") Long productId, @Param("quantity") Long quantity);

    @Modifying
    @Query(value = "DELETE FROM cart_products WHERE cart_id = (SELECT cart_id FROM carts WHERE user_id = :userId) AND product_id = :productId", nativeQuery = true)
    void deleteProduct(@Param("userId") Long userId, @Param("productId") Long productId);
}
