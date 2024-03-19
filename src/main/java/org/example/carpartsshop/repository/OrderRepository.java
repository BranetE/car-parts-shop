package org.example.carpartsshop.repository;

import org.example.carpartsshop.model.Order;
import org.example.carpartsshop.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Modifying
    @Query(value = "UPDATE orders SET status=:status WHERE id=:orderId", nativeQuery = true)
    void changeStatus(@Param("orderId") Long orderId, @Param("status") OrderStatus status);
}
