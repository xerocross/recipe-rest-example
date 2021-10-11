package com.adamfgcross.restdemo.services;

import com.adamfgcross.restdemo.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    Recipe save(Recipe recipe);

    List<Recipe> findAll();

    Optional<Recipe> get(Long id);
}
