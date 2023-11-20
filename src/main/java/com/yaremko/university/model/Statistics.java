package com.yaremko.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Statistics {

    private Degree degree;

    private Long quantity;

}
