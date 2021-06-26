package personal.nutrisport.fatsecret;

import org.junit.jupiter.api.Test;
import personal.nutrisport.fatsecret.model.Food;
import personal.nutrisport.fatsecret.model.Recipe;
import personal.nutrisport.fatsecret.model.SimpleFood;
import personal.nutrisport.fatsecret.model.SimpleRecipe;
import personal.nutrisport.fatsecret.utils.request.Request;
import personal.nutrisport.fatsecret.utils.response.ResponseSuccess;

import java.util.List;

public class WebAPITest {
    private static final String FOOD_NAME = "banana";
    private static final String RECIPE_NAME = "cake";
    private static final long FOOD_ID = 285243L;
    private static final long RECIPE_ID = 315L;
    private final FatSecretWebAPI api;

    public WebAPITest() {
        api = new FatSecretWebAPI(new Request());
    }

    @Test
    public void testSearchFood() {
        ResponseSuccess<SimpleFood> resp = api.searchFoods(FOOD_NAME);
        int totalResults = resp.getTotalResults();
        List<SimpleFood> resultList = resp.getResultList();
        System.out.println("Total results retrieved: " + totalResults);
        resultList.forEach(System.out::println);
    }

    @Test
    public void testSearchRecipe() {
        ResponseSuccess<SimpleRecipe> resp = api.searchRecipes(RECIPE_NAME);
        int totalResults = resp.getTotalResults();
        List<SimpleRecipe> resultList = resp.getResultList();
        System.out.println("Total results retrieved: " + totalResults);
        resultList.forEach(System.out::println);
    }

    @Test
    public void testGetFoodByID() {
        Food food = api.getFood(FOOD_ID);
        System.out.println(food.toString());
    }

    @Test
    public void testGetRecipeByID() {
        Recipe recipe = api.getRecipe(RECIPE_ID);
        System.out.println(recipe.toString());
    }
}
