package com.fotokeramica.repositories;

import com.fotokeramica.domain.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepositories extends CrudRepository<Point, Integer> {

    List<Point> findByPointName(String pointName);

    @Query(value = "SELECT COUNT(*) FROM fc_point", nativeQuery = true)
    Integer findCountPoint();
}
