package com.adamfgcross.restdemo.controllers;

import com.adamfgcross.restdemo.models.Recipe;
import com.adamfgcross.restdemo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;


    @PostMapping("/recipe")
    public ResponseEntity<Recipe> postRecipe(@RequestBody Recipe recipe) {
       Recipe savedRecipe = recipeService.save(recipe);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe);
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
