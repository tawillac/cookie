package de.infoteam.twi.cookie.rest;

import de.infoteam.twi.cookie.entities.Recipe;
import de.infoteam.twi.cookie.jpa.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RecipeRestController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        System.out.println("getAllRecipes()");
        return recipeRepository.findAll();
    }

    @GetMapping("/recipes/{name}")
    public Recipe getRecipeByName(@PathVariable String name) {
        System.out.println("getRecipeByName(" + name + ")");
        Optional<Recipe> recipeOpt = recipeRepository.findById(name);
        if (recipeOpt.isPresent()) {
            return recipeOpt.get();
        } else {
            System.err.println("getRecipeByName(" + name + ") -> No Result");
            return null;
        }
    }

    // Create New -> POST
    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        System.out.println("addRecipe(" + recipe.getName() + ")");
        recipeRepository.save(recipe);
        return recipe;
    }

    // Update Existing -> PUT
    @PutMapping("/recipes")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        System.out.println("updateRecipe(" + recipe.getName() + ")");
        recipeRepository.save(recipe);
        return recipe;
    }

    @DeleteMapping("recipes/{name}")
    public void deleteRecipe(@PathVariable String name) {
        System.out.println("deleteRecipe(" + name + ")");
        Optional<Recipe> recipeOpt = recipeRepository.findById(name);
        if (recipeOpt.isPresent()) {
            recipeRepository.delete(recipeOpt.get());
        } else {
            System.err.println("deleteRecipe(" + name + ") -> not possible, does not exist");
        }


    }

}
