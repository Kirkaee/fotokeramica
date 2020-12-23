package com.fotokeramica.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fc_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id")
    private Point point;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "order_date")
    private LocalDate startDate;
    @Column(name = "order_number")
    private int number;
    @Column(name = "order_carcass")
    private String carcass;
    @Column(name = "order_last_name")
    private String lastName;
    @Column(name = "order_holes")
    private String holes;
    @Column(name = "order_size")
    private String size;
    @Column(name = "order_price")
    private int price;
    @Column(name= "point_name")
    private String pointName;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public LocalDate getDate() {
        return startDate;
    }

    public void setDate(LocalDate date) {
        this.startDate = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarcass() {
        return carcass;
    }

    public void setCarcass(String carcass) {
        this.carcass = carcass;
    }

    public String getHoles() {
        return holes;
    }

    public void setHoles(String holes) {
        this.holes = holes;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }
}
