package com.aljumaro.techtest.persistence.recipe;

import com.aljumaro.techtest.domain.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @Date 05/04/2016
 * @Time 22:57
 * @Author Juanma
 */
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
}
