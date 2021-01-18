package com.fotokeramica.service;

import com.fotokeramica.domain.Point;
import com.fotokeramica.repositories.PointRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    private PointRepositories pointRepositories;

    public void savePoint(String pointName, String firstName, String lastName, String address,
                          String phone, String typeOfTransfer){
        Point point = new Point();
        point.setPointName(pointName);
        point.setFirstName(firstName);
        point.setLastName(lastName);
        point.setAddress(address);
        point.setPhone(phone);
        point.setTypeOfTransfer(typeOfTransfer);
        pointRepositories.save(point);
    }

    public Iterable<Point> allPoints(){
        Iterable<Point> points = pointRepositories.findAll();
        return points;
    }
}
