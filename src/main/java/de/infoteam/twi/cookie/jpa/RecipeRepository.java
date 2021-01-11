package de.infoteam.twi.cookie.jpa;

import de.infoteam.twi.cookie.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {
    /*

    //void setDataSource(DataSource ds);

    //void createNewRecipe(String name, String ingredients, String instructions);

    Recipe getRecipeByName(String name);

    List<Recipe> getAllRecipes();

    //void deleteAllRecipes();

    //void deleteRecipe(String name);

     */
}
