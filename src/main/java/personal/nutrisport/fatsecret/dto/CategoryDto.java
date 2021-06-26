package personal.nutrisport.fatsecret.dto;

import org.json.JSONArray;
import org.json.JSONObject;
import personal.nutrisport.fatsecret.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {
    public static List<Category> parseCategoriesFromJSONArray(JSONObject recipeCategories) {
        List<Category> categories = new ArrayList<>();

        JSONArray catsArray = null;
        try {
            catsArray = recipeCategories.getJSONArray("recipe_category");
        } catch(Exception e) { /* ignore missing array */ }

        if (catsArray != null)
            for (int i = 0; i < catsArray.length(); i++)
                categories.add(
                        parseCategoryFromJSON(catsArray.getJSONObject(i))
                );

        else categories.add(
                parseCategoryFromJSON(
                        recipeCategories.getJSONObject("recipe_category")
                )
        );
        return categories;
    }

    public static Category parseCategoryFromJSON(JSONObject json) {
        return new Category(
                json.getString("recipe_category_name"),
                json.getString("recipe_category_url")
        );
    }
}
