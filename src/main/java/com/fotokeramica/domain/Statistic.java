package com.fotokeramica.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Statistic {
    private Integer countOrder;
    private Integer countPoint;
    private Integer money;
}
