package personal.nutrisport.fatsecret.dto;

import org.json.JSONArray;
import org.json.JSONObject;
import personal.nutrisport.fatsecret.model.Food;
import personal.nutrisport.fatsecret.model.SimpleFood;

import java.util.ArrayList;
import java.util.List;

public class FoodDto {

    public static Food parseFoodFromJSON(JSONObject json) {
        return new Food(
                Long.parseLong(json.getString("food_id")),
                json.getString("food_name"),
                json.getString("food_url"),
                json.getString("food_type"),
                ServingDto.parseServingsFromJSONArray(json.getJSONObject("servings"))
        );
    }

    public static SimpleFood parseSimpleFoodFromJSON(JSONObject json) {
        return new SimpleFood(
                Long.parseLong(json.getString("food_id")),
                json.getString("food_name"),
                json.getString("food_url"),
                json.getString("food_type")
        );
    }

    public static List<SimpleFood> parseSimpleFoodFromJSONArray(JSONArray foodsJson) {
        List<SimpleFood> foods = new ArrayList<>();
        for (int i = 0; i < foodsJson.length(); i++)
            foods.add(parseSimpleFoodFromJSON(foodsJson.getJSONObject(i)));
        return foods;
    }
}
