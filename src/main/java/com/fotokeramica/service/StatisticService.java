package com.fotokeramica.service;

import com.fotokeramica.domain.Statistic;
import com.fotokeramica.repositories.OrderRepositories;
import com.fotokeramica.repositories.PointRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {
    @Autowired
    private OrderRepositories orderRepositories;
    @Autowired
    private PointRepositories pointRepositories;
    @Autowired
    private Statistic statistic;

    public Statistic getStatistic(){
        statistic.setCountPoint(pointRepositories.findCountPoint());
        statistic.setCountOrder(orderRepositories.findCountOrder());
        statistic.setMoney(orderRepositories.findSumMoney());
        return statistic;
    }
}
