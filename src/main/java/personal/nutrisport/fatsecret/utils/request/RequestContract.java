package personal.nutrisport.fatsecret.utils.request;

import org.json.JSONObject;

public interface RequestContract {
    JSONObject searchFoods(String query, int pageNumber);

    JSONObject getFood(long id);

    //JSONObject getFoods();

    JSONObject searchRecipes(String query, int pageNumber);

    JSONObject getRecipe(long id);

    //JSONObject getRecipes();
}
