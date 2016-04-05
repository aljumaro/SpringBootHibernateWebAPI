package com.aljumaro.techtest.service.recipe;

import com.aljumaro.techtest.domain.recipe.Recipe;
import com.aljumaro.techtest.persistence.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Date 05/04/2016
 * @Time 22:54
 * @Author Juanma
 */
@Component
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
}
