package personal.nutrisport.fatsecret.dto;

import org.json.JSONArray;
import org.json.JSONObject;
import personal.nutrisport.fatsecret.model.RecipeStep;

import java.util.ArrayList;
import java.util.List;

public class RecipeStepDto {
    public static List<RecipeStep> parseRecipeStepsFromJSONArray(JSONObject stepsJson) {
        List<RecipeStep> recipeSteps = new ArrayList<>();

        JSONArray stepsArray = null;
        try {
            stepsArray = stepsJson.getJSONArray("direction");
        } catch (Exception e) { /*ignore missing array*/ }

        if (stepsArray != null)
            for (int i = 0; i < stepsArray.length(); i++)
                recipeSteps.add(
                        parseRecipeStepFromJSON(stepsArray.getJSONObject(i))
                );
        else recipeSteps.add(
                parseRecipeStepFromJSON(
                        stepsJson.getJSONObject("direction")
                )
        );

        return recipeSteps;
    }

    public static RecipeStep parseRecipeStepFromJSON(JSONObject json) {
        return new RecipeStep(
                Integer.parseInt(json.getString("direction_number")),
                json.getString("direction_description")
        );
    }
}
