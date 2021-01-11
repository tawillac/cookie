package de.infoteam.twi.cookie.websockets;

import de.infoteam.twi.cookie.entities.Recipe;
import de.infoteam.twi.cookie.entities.Request;
import de.infoteam.twi.cookie.jpa.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @MessageMapping("/request")
    @SendTo("/topic/recipes")
    public Recipe recipe(Request request) throws Exception {
        Thread.sleep(1000);
        Optional<Recipe> recipeOpt = recipeRepository.findById(request.getRecipeName());
        if (recipeOpt.isPresent()) {
            return recipeOpt.get();
        } else {
            System.err.println("getRecipeByName(" + request.getRecipeName() + ") -> No Result");
            Recipe recipe = new Recipe(request.getRecipeName());
            recipe.setInstructions("do this");
            recipe.setIngredients("use this");
            return recipe;
        }
    }
}
