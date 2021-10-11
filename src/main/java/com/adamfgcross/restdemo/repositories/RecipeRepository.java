package com.adamfgcross.restdemo.repositories;

import com.adamfgcross.restdemo.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
