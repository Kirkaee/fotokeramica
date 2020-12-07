package com.fotokeramica.controller;

import com.fotokeramica.domain.Point;
import com.fotokeramica.repositories.PointRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PointController {

    @Autowired
    private PointRepositories pointRepositories;

    @GetMapping("/points")
    public String points(Map<String, Object> model) {
        Iterable<Point> points = pointRepositories.findAll();
        model.put("points", points);
        return "points";
    }

    @GetMapping("/createPoint")
    public String createPoint(Map<String, Object> model){
        Iterable<Point> points = pointRepositories.findAll();
        model.put("points", points);
        return "createPoint";
    }

    @PostMapping("/createPoint")
    public String add(@RequestParam (value = "PointName", required = false, defaultValue = "defaultName")
                                  String pointName, @RequestParam String firstName,
                      @RequestParam String lastName, @RequestParam String address,
                      @RequestParam String phone, @RequestParam String typeOfTransfer,
                      Map<String, Object> model){
        Point point = new Point();
        point.setPointName(pointName);
        point.setFirstName(firstName);
        point.setLastName(lastName);
        point.setAddress(address);
        point.setPhone(phone);
        point.setTypeOfTransfer(typeOfTransfer);
        pointRepositories.save(point);

        Iterable<Point> points = pointRepositories.findAll();
        model.put("points", points);
        return "createPoint";
    }
}
