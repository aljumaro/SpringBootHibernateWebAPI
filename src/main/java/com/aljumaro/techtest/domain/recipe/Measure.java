package com.aljumaro.techtest.domain.recipe;

import javax.persistence.Entity;

/**
 * @Date 03/04/2016
 * @Time 9:15
 * @Author Juanma
 */
public enum Measure {

    GRAMS("grams"),
    LITERS("liters");

    private String description;

    Measure(String description) {
        this.description = description;
    }
}
