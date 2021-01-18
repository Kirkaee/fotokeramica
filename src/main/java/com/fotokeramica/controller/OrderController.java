package com.fotokeramica.controller;

import com.fotokeramica.service.OrderService;
import com.fotokeramica.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PointService pointService;

    @GetMapping("/orders")
    public String order(Map<String, Object> model){
        model.put("orders", orderService.allOrders());
        return "orders";
    }

    @GetMapping("/createOrder")
    public String createOrder(Map<String, Object> model){
        model.put("orders", orderService.allOrders());
        return "createOrder";
    }

    @PostMapping("/createOrder")
    public String add(@RequestParam String pointName,
                      @RequestParam int number, @RequestParam String carcass,
                      @RequestParam String lastName,
                      @RequestParam String holes, @RequestParam String size,
                      @RequestParam int price,
                      Map<String, Object> model){
        orderService.saveOrder(pointName, number, carcass, lastName, holes, size, price);
        model.put("orders", orderService.allOrders());
        return "createOrder";
    }

    @PostMapping("filterOfPoint")
    public String filterOfPoint(@RequestParam String pointName, Map<String, Object> model){
        model.put("orders", orderService.findOfPointName(pointName));
        return "orders";
    }

    @PostMapping("filterOfDate")
    public String filterOfDate(@RequestParam(defaultValue = "2020-01-01") @DateTimeFormat(pattern="yyyy-MM-dd")
                                           LocalDate date1,
                               //todo
                               @RequestParam(defaultValue = "2030-01-01") @DateTimeFormat(pattern="yyyy-MM-dd")
                                       LocalDate date2,
                               Map<String, Object> model){
        model.put("orders", orderService.findOfDate(date1, date2));
        return "orders";
    }

}
