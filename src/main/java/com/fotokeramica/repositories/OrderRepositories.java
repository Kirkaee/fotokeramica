package com.fotokeramica.repositories;

import com.fotokeramica.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepositories extends CrudRepository<Order, Integer> {
}
