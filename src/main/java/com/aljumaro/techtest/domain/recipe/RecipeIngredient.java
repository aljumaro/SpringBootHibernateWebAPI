package com.aljumaro.techtest.domain.recipe;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @Date 03/04/2016
 * @Time 9:21
 * @Author Juanma
 */
@Entity
public class RecipeIngredient implements Serializable{

    @Id
    @ManyToOne
    public Recipe recipe;

    @Id
    @ManyToOne
    public Ingredient ingredient;

    public double quantity;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
