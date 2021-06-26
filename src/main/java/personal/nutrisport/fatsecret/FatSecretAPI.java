package personal.nutrisport.fatsecret;

import personal.nutrisport.fatsecret.model.Food;
import personal.nutrisport.fatsecret.model.Recipe;
import personal.nutrisport.fatsecret.model.SimpleFood;
import personal.nutrisport.fatsecret.model.SimpleRecipe;
import personal.nutrisport.fatsecret.utils.response.ResponseSuccess;

public interface FatSecretAPI {

    Food getFood(long foodID);

    ResponseSuccess<SimpleFood> searchFoods(String query);

    ResponseSuccess<SimpleFood> searchFoods(String query, int pageNumber);


    Recipe getRecipe(long recipeID);

    ResponseSuccess<SimpleRecipe> searchRecipes(String query);

    ResponseSuccess<SimpleRecipe> searchRecipes(String query, int pageNumber);

}
