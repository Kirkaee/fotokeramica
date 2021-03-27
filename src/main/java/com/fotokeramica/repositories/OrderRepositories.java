package com.fotokeramica.repositories;

import com.fotokeramica.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface OrderRepositories extends CrudRepository<Order, Integer> {

    List<Order> findByPointName(String pointName);

    List<Order> findByStartDateBetween(LocalDate start, LocalDate end);

    @Query(value = "SELECT COUNT(*) FROM fc_order", nativeQuery = true)
    Integer findCountOrder();

    @Query(value = "SELECT SUM(order_price) FROM fc_order", nativeQuery = true)
    Integer findSumMoney();
}
