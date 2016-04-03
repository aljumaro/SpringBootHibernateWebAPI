package com.aljumaro.techtest.domain.recipe;

import com.aljumaro.techtest.domain.base.BaseEntity;

/**
 * @Date 03/04/2016
 * @Time 9:07
 * @Author Juanma
 */
public class Ingredient extends BaseEntity {

    private String name;
    private Category category;
    private Measure measure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
