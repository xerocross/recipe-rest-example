package com.adamfgcross.restdemo.services;

import com.adamfgcross.restdemo.models.Recipe;
import com.adamfgcross.restdemo.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = new ArrayList<>();
        for (Recipe recipe : recipeRepository.findAll()) {
            recipes.add(recipe);
        }
        return recipes;
    }
}
