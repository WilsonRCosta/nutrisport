package personal.nutrisport.fatsecret.dto;

import org.json.JSONArray;
import org.json.JSONObject;
import personal.nutrisport.fatsecret.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientDto {
    public static List<Ingredient> parseIngredientsFromJSONArray(JSONObject ingredientsJson) {
        List<Ingredient> ingredients = new ArrayList<>();

        JSONArray ingredientsArray = null;
        try {
            ingredientsArray = ingredientsJson.getJSONArray("ingredient");
        } catch (Exception e) { /*ignore missing array*/ }

        if (ingredientsArray != null)
            for (int i = 0; i < ingredientsArray.length(); i++)
                ingredients.add(
                        parseIngredientFromJSON(ingredientsArray.getJSONObject(i))
                );
        else ingredients.add(
                parseIngredientFromJSON(
                        ingredientsJson.getJSONObject("ingredient")
                )
        );

        return ingredients;
    }

    public static Ingredient parseIngredientFromJSON(JSONObject json) {
        return new Ingredient(
                Long.parseLong(json.getString("food_id")),
                Long.parseLong(json.getString("serving_id")),
                json.getString("ingredient_description"),
                json.getString("food_name"),
                json.getString("ingredient_url"),
                json.getString("measurement_description"),
                Float.parseFloat(json.getString("number_of_units"))
        );
    }
}
