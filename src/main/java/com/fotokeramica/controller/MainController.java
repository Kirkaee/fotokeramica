package com.fotokeramica.controller;

import com.fotokeramica.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("statistic",statisticService.getStatistic());
        return "main";
    }

}
