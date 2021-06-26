package personal.nutrisport.fatsecret.dto;

import org.json.JSONArray;
import org.json.JSONObject;
import personal.nutrisport.fatsecret.model.Serving;

import java.util.ArrayList;
import java.util.List;

public class ServingDto {

    public static List<Serving> parseServingsFromJSONArray(JSONObject jsonServings) {
        List<Serving> servings = new ArrayList<>();

        JSONArray servingsArray = null;
        try {
            servingsArray = jsonServings.getJSONArray("serving");
        } catch (Exception e) { /*ignore missing array*/ }

        if(servingsArray != null)
            for (int i = 0; i < servingsArray.length(); i++)
                servings.add(
                        parseServingFromJSONObject(servingsArray.getJSONObject(i))
                );
        else servings.add(
                parseServingFromJSONObject(
                        jsonServings.getJSONObject("serving")
                )
        );
        return servings;
    }

    public static Serving parseServingFromJSONObject(JSONObject json) {
        return new Serving(
                Long.parseLong(json.getString("serving_id")),
                json.getString("serving_description"),
                json.getString("serving_url"),
                Float.parseFloat(json.getString("metric_serving_amount")),
                json.getString("metric_serving_unit"),
                Float.parseFloat(json.getString("number_of_units")),
                json.getString("measurement_description"),
                NutritionTableDto.parseNutritionFromJSONObject(json)
        );
    }
}
