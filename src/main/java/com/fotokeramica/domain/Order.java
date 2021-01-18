package com.fotokeramica.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
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

}
