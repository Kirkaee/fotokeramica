package com.fotokeramica.service;

import com.fotokeramica.domain.Order;
import com.fotokeramica.domain.Point;
import com.fotokeramica.repositories.OrderRepositories;
import com.fotokeramica.repositories.PointRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepositories orderRepositories;

    @Autowired
    private PointRepositories pointRepositories;

    public Iterable<Order> allOrders() {
        Iterable<Order> orders = orderRepositories.findAll();
        return orders;
    }

    public void saveOrder(String pointName, int number, String carcass,
                           String lastName, String holes, String size, int price){
        Order order = new Order();

        // point existence logic
        List<Point> points = pointRepositories.findByPointName(pointName);
        if (!points.isEmpty()) {
            Point point = points.get(0);
            order.setPoint(point);
            order.setPointName(point.getPointName());
        }
        order.setStartDate(LocalDate.now());
        order.setNumber(number);
        order.setCarcass(carcass);
        order.setLastName(lastName);
        order.setHoles(holes);
        order.setSize(size);
        order.setPrice(price);
        orderRepositories.save(order);
    }

    public Iterable<Order> findOfPointName (String pointName){
        Iterable<Order> orders;
        if (pointName !=null && !pointName.isEmpty()){
            orders = orderRepositories.findByPointName(pointName);
        } else {
            orders = orderRepositories.findAll();
        }
        return orders;
    }

    public Iterable<Order> findOfDate(LocalDate date1, LocalDate date2){
        Iterable<Order> orders = orderRepositories.findByStartDateBetween(date1, date2);
        return orders;
    }

}
