package com.fotokeramica.controller;

import com.fotokeramica.domain.Order;
import com.fotokeramica.domain.Point;
import com.fotokeramica.repositories.OrderRepositories;
import com.fotokeramica.repositories.PointRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderRepositories orderRepositories;

    @Autowired
    private PointRepositories pointRepositories;

    @GetMapping("/orders")
    public String order(Map<String, Object> model){
        Iterable<Order> orders = orderRepositories.findAll();
        model.put("orders", orders);
        return "orders";
    }

    @GetMapping("/createOrder")
    public String createOrder(Map<String, Object> model){
        Iterable<Order> orders = orderRepositories.findAll();
        model.put("orders", orders);
        return "createOrder";
    }

    @PostMapping("/createOrder")
    public String add(@RequestParam String pointName,
                      @RequestParam int number, @RequestParam String carcass,
                      @RequestParam String lastName,
                      @RequestParam String holes, @RequestParam String size,
                      @RequestParam int price,
                      Map<String, Object> model){
        Order order = new Order();

        // point existence logic
        List<Point> points = pointRepositories.findByPointName(pointName);
        if (!points.isEmpty()) {
            Point point = points.get(0);
            order.setPoint(point);
            order.setPointName(point.getPointName());
        }
        order.setDate(LocalDate.now());
        order.setNumber(number);
        order.setCarcass(carcass);
        order.setLastName(lastName);
        order.setHoles(holes);
        order.setSize(size);
        order.setPrice(price);
        orderRepositories.save(order);

        Iterable<Order> orders = orderRepositories.findAll();
        model.put("orders", orders);
        return "createOrder";
    }

    @PostMapping("filterOfPoint")
    public String filterOfPoint(@RequestParam String pointName, Map<String, Object> model){
        Iterable<Order> orders;
        if (pointName !=null && !pointName.isEmpty()){
            orders = orderRepositories.findByPointName(pointName);
        } else {
            orders = orderRepositories.findAll();
        }
        model.put("orders", orders);

        return "orders";
    }

    @PostMapping("filterOfDate")
    public String filterOfDate(@RequestParam(defaultValue = "2020-01-01") @DateTimeFormat(pattern="yyyy-MM-dd")
                                           LocalDate date1,
                               //todo
                               @RequestParam(defaultValue = "2030-01-01") @DateTimeFormat(pattern="yyyy-MM-dd")
                                       LocalDate date2,
                               Map<String, Object> model){
        Iterable<Order> orders;
        orders = orderRepositories.findByStartDateBetween(date1, date2);
        model.put("orders", orders);

        return "orders";
    }

}
