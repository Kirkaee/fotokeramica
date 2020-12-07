package com.fotokeramica.repositories;

import com.fotokeramica.domain.Point;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRepositories extends CrudRepository<Point, Integer> {

    List<Point> findByPointName(String pointName);
}
