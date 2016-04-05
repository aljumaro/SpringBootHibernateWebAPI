package com.aljumaro.techtest.web.recipe;

import com.aljumaro.techtest.domain.recipe.Recipe;
import com.aljumaro.techtest.service.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @Date 05/04/2016
 * @Time 22:51
 * @Author Juanma
 */
@RestController("/v1/recipe")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping
    public List<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }

}
