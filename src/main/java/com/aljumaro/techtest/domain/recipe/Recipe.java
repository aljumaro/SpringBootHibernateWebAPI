package com.aljumaro.techtest.domain.recipe;

import com.aljumaro.techtest.domain.base.BaseEntity;

import java.util.List;

/**
 * @Date 03/04/2016
 * @Time 9:06
 * @Author Juanma
 */
public class Recipe extends BaseEntity {

    private String name;
    private int diners;
    private List<String> steps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiners() {
        return diners;
    }

    public void setDiners(int diners) {
        this.diners = diners;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
