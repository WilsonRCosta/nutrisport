package personal.nutrisport.fatsecret.dto;

import org.json.JSONArray;
import org.json.JSONObject;
import personal.nutrisport.fatsecret.model.*;

import java.util.ArrayList;
import java.util.List;



public class RecipeDto {

    public static List<SimpleRecipe> parseRecipesFromJSONArray(JSONArray recipesJson) {
        List<SimpleRecipe> recipes = new ArrayList<>();
        for (int i = 0; i < recipesJson.length(); i++)
            recipes.add(parseSearchRecipeFromJSONObject(recipesJson.getJSONObject(i)));
        return recipes;
    }

    public static SimpleRecipe parseSearchRecipeFromJSONObject(JSONObject json) {
        SimpleNutritionTable table = NutritionTableDto.parseSimpleNutritionFormJSONObject(json.getJSONObject("recipe_nutrition"));
        long id = Long.parseLong(json.getString("recipe_id"));
        String description = json.getString("recipe_description");
        String name = json.getString("recipe_name");
        String url = json.getString("recipe_url");
        return new SimpleRecipe(name, url, description, id, table);
    }

    public static Recipe parseRecipeFromJSONObject(JSONObject json) {
        String name = json.getString("recipe_name");
        String url = json.getString("recipe_url");
        String description = json.getString("recipe_description");
        long id = Long.parseLong(json.getString("recipe_id"));
        List<String> images = parseStringFromJSONArray(json.getJSONObject("recipe_images"), "recipe_image");
        int rating = Integer.parseInt(json.getString("rating"));
        List<String> types = parseStringFromJSONArray(json.getJSONObject("recipe_types"), "recipe_type");
        int servings = Integer.parseInt(json.getString("number_of_servings"));
        int prepTime = Integer.parseInt(json.getString("preparation_time_min"));
        int cookTime = Integer.parseInt(json.getString("cooking_time_min"));
        NutritionTable nutritionTable = NutritionTableDto.parseNutritionFromJSONObject(json.getJSONObject("serving_sizes").getJSONObject("serving"));
        List<Category> categories = CategoryDto.parseCategoriesFromJSONArray(json.getJSONObject("recipe_categories"));
        List<RecipeStep> steps = RecipeStepDto.parseRecipeStepsFromJSONArray(json.getJSONObject("directions"));
        List<Ingredient> ingredients = IngredientDto.parseIngredientsFromJSONArray(json.getJSONObject("ingredients"));

        return new Recipe(name, url, description, id, images, rating, types, servings,
                prepTime, cookTime, nutritionTable, categories, steps, ingredients);
    }

    private static List<String> parseStringFromJSONArray(JSONObject json, String objName) {
        List<String> elems = new ArrayList<>();
        JSONArray array = null;

        try {
            array = json.getJSONArray(objName); // try to acquire the array
        } catch (Exception e) { /* ignore missing array */ }

        if (array != null) array.forEach(elem -> elems.add((String) elem)); // add the array elems to the list
        else elems.add(json.getString(objName)); // if its not an array, add the single elem

        return elems;
    }
}
