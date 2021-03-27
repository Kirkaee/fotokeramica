package com.fotokeramica.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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
}
