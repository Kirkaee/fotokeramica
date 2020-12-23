package com.fotokeramica.domain;

import javax.persistence.*;

@Entity
@Table(name = "fc_point")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //внести зависимость
    @Column(name = "point_id")
    private Integer id;

    @Column(name = "point_name")
    private String pointName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "point_address")
    private String address;
    @Column(name = "point_phone")
    private String phone;
    @Column(name = "point_type_of_transfer")
    private String typeOfTransfer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeOfTransfer() {
        return typeOfTransfer;
    }

    public void setTypeOfTransfer(String typeOfTransfer) {
        this.typeOfTransfer = typeOfTransfer;
    }
}
