package com.yaremko.university.model;

import lombok.Getter;

@Getter
public enum Degree {

    ASSISTANT("assistant"),
    ASSOCIATE_PROFESSOR("associate professor"),
    PROFESSOR("professor");

    public final String degree;

    Degree(String degree) {
        this.degree = degree;
    }

}
