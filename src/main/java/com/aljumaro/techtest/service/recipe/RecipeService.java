package com.aljumaro.techtest.service.recipe;

import com.aljumaro.techtest.domain.recipe.Recipe;

import java.util.List;

/**
 * @Date 05/04/2016
 * @Time 22:53
 * @Author Juanma
 */
public interface RecipeService {

    List<Recipe> getRecipes();
}
