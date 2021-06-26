package personal.nutrisport.fatsecret;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.nutrisport.fatsecret.dto.FoodDto;
import personal.nutrisport.fatsecret.dto.RecipeDto;
import personal.nutrisport.fatsecret.model.Food;
import personal.nutrisport.fatsecret.model.Recipe;
import personal.nutrisport.fatsecret.model.SimpleFood;
import personal.nutrisport.fatsecret.model.SimpleRecipe;
import personal.nutrisport.fatsecret.utils.request.Request;
import personal.nutrisport.fatsecret.utils.response.ResponseSuccess;

import java.util.ArrayList;
import java.util.List;

@Service
public class FatSecretWebAPI implements FatSecretAPI {

    private final Request request;

    @Autowired
    public FatSecretWebAPI(Request request) {
       this.request = request;
    }

    @Override
    public Food getFood(long foodID) {
        JSONObject response = request.getFood(foodID);
        if (response != null)
            if(response.has("result"))
                return FoodDto.parseFoodFromJSON(response.getJSONObject("result").getJSONObject("food"));
            else if (response.has("error"))
                System.err.println(response.getJSONObject("error"));
        return null;
    }

    @Override
    public ResponseSuccess<SimpleFood> searchFoods(String query) {
        return searchFoods(query, 0);
    }

    @Override
    public ResponseSuccess<SimpleFood> searchFoods(String query, int pageNumber) {
        JSONObject foodJson = request.searchFoods(query, pageNumber);
        try {
            if(foodJson != null) {
                if(foodJson.has("error"))
                    throw new Exception(foodJson.getJSONObject("error").getJSONObject("message").toString());

                JSONObject foods = foodJson.getJSONObject("result").getJSONObject("foods");
                int maxResults = foods.getInt("max_results");
                int totalResults = foods.getInt("total_results");

                List<SimpleFood> results = new ArrayList<>();
                if(totalResults > maxResults * pageNumber)
                    results = FoodDto.parseSimpleFoodFromJSONArray(foods.getJSONArray("food"));

                return new ResponseSuccess<>(pageNumber,maxResults, totalResults, results);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Recipe getRecipe(long recipeID) {
        JSONObject response = request.getRecipe(recipeID);
        if (response != null && response.has("result"))
            return RecipeDto.parseRecipeFromJSONObject(response.getJSONObject("result").getJSONObject("recipe"));
        return null;
    }

    @Override
    public ResponseSuccess<SimpleRecipe> searchRecipes(String query) {
        return searchRecipes(query, 0);
    }

    @Override
    public ResponseSuccess<SimpleRecipe> searchRecipes(String query, int pageNumber) {
        JSONObject json = request.searchRecipes(query, pageNumber);
        try {
            if(json != null) {
                JSONObject recipes = json.getJSONObject("result").getJSONObject("recipes");

                int maxResults = recipes.getInt("max_results");
                int totalResults = recipes.getInt("total_results");

                List<SimpleRecipe> results = new ArrayList<>();
                if(totalResults > maxResults * pageNumber)
                    results = RecipeDto.parseRecipesFromJSONArray(recipes.getJSONArray("recipe"));
                return new ResponseSuccess<>(pageNumber, maxResults, totalResults, results);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }


}
