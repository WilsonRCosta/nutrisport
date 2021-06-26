package personal.nutrisport.fatsecret.dto;

import org.json.JSONObject;
import personal.nutrisport.fatsecret.model.NutritionTable;
import personal.nutrisport.fatsecret.model.SimpleNutritionTable;

public class NutritionTableDto {

    public static NutritionTable parseNutritionFromJSONObject(JSONObject json) {
        float transFat = -1, vitamin_d = -1, added_sugars = -1;
        try {
            transFat = Float.parseFloat(json.getString("trans_fat"));
            vitamin_d = Float.parseFloat(json.getString("vitamin_d"));
            added_sugars = Float.parseFloat(json.getString("added_sugars"));
        } catch (Exception exp) { /* ignore not assigned params */ }

        return new NutritionTable(
                Float.parseFloat(json.getString("calories")),
                Float.parseFloat(json.getString("carbohydrate")),
                Float.parseFloat(json.getString("protein")),
                Float.parseFloat(json.getString("fat")),
                Float.parseFloat(json.getString("saturated_fat")),
                Float.parseFloat(json.getString("polyunsaturated_fat")),
                Float.parseFloat(json.getString("monounsaturated_fat")),
                transFat,
                Float.parseFloat(json.getString("cholesterol")),
                Float.parseFloat(json.getString("sodium")),
                Float.parseFloat(json.getString("potassium")),
                Float.parseFloat(json.getString("fiber")),
                Float.parseFloat(json.getString("sugar")),
                Float.parseFloat(json.getString("vitamin_a")),
                Float.parseFloat(json.getString("vitamin_c")),
                vitamin_d,
                Float.parseFloat(json.getString("calcium")),
                Float.parseFloat(json.getString("iron")),
                added_sugars
        );
    }

    public static SimpleNutritionTable parseSimpleNutritionFormJSONObject(JSONObject json) {
         return new SimpleNutritionTable(
                    Float.parseFloat(json.getString("calories")),
                    Float.parseFloat(json.getString("carbohydrate")),
                    Float.parseFloat(json.getString("protein")),
                    Float.parseFloat(json.getString("fat"))
         );
    }
}