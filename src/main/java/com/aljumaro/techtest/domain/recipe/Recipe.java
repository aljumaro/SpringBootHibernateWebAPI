package com.aljumaro.techtest.domain.recipe;

import com.aljumaro.techtest.domain.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 03/04/2016
 * @Time 9:06
 * @Author Juanma
 */
@Entity
public class Recipe extends BaseEntity {

    private String name;
    private int diners;

    @ElementCollection
    private List<String> steps;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();

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

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
