package com.adamfgcross.restdemo.controllers;

import com.adamfgcross.restdemo.models.Recipe;
import com.adamfgcross.restdemo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> postRecipe(@RequestBody Recipe recipe) {
       Recipe savedRecipe = recipeService.save(recipe);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Optional<Recipe> recipeOptional = recipeService.get(id);
        if (recipeOptional.isPresent()) {
            return ResponseEntity.ok(recipeOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PutMapping("/recipe")
    public ResponseEntity<Recipe> putRecipe(@RequestBody Recipe recipe) {
        Long id = recipe.getId();
        if (id == null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(recipe);
        }
        Recipe savedRecipe = recipeService.save(recipe);
        return ResponseEntity.ok().body(savedRecipe);
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("/ping")
    public ResponseEntity<String> getPing() {
        return ResponseEntity.ok("");
    }
}
