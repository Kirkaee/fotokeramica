package com.fotokeramica.controller;

import com.fotokeramica.domain.Point;
import com.fotokeramica.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PointController {

    @Autowired
    private PointService pointService;

    @GetMapping("/points")
    public String points(Map<String, Object> model) {
        Iterable<Point> points = pointService.allPoints();
        model.put("points", points);
        return "points";
    }

    @GetMapping("/createPoint")
    public String createPoint(Map<String, Object> model){
        Iterable<Point> points = pointService.allPoints();
        model.put("points", points);
        return "createPoint";
    }

    @PostMapping("/createPoint")
    public String add(@RequestParam (value = "PointName", required = false, defaultValue = "defaultName")
                                  String pointName, @RequestParam String firstName,
                      @RequestParam String lastName, @RequestParam String address,
                      @RequestParam String phone, @RequestParam String typeOfTransfer,
                      Map<String, Object> model){
        pointService.savePoint(pointName, firstName, lastName, address, phone, typeOfTransfer);

        Iterable<Point> points = pointService.allPoints();
        model.put("points", points);
        return "createPoint";
    }
}
