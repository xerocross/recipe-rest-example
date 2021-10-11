package com.adamfgcross.restdemo.services;

import com.adamfgcross.restdemo.models.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe save(Recipe recipe);

    List<Recipe> findAll();
}
