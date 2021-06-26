package personal.nutrisport.fatsecret;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.nutrisport.common.Common.*;
import personal.nutrisport.fatsecret.model.Food;
import personal.nutrisport.fatsecret.model.Recipe;
import personal.nutrisport.fatsecret.model.SimpleFood;
import personal.nutrisport.fatsecret.model.SimpleRecipe;
import personal.nutrisport.fatsecret.utils.response.ResponseSuccess;

@RestController
@RequestMapping(Href.FAT_SECRET)
public class FatSecretController {

    private final FatSecretWebAPI fatSecretWebAPI;

    @Autowired
    public FatSecretController(FatSecretWebAPI fatSecretWebAPI) {
        this.fatSecretWebAPI = fatSecretWebAPI;
    }

    @GetMapping(path = Href.RECIPE, produces = MIMEType.APPLICATION_JSON)
    public Recipe getRecipeByID(@PathVariable("id") long id) {
        return fatSecretWebAPI.getRecipe(id);
    }

    @GetMapping(path = Href.FOOD, produces = MIMEType.APPLICATION_JSON)
    public Food getFoodByID(@PathVariable("id") long id) {
        return fatSecretWebAPI.getFood(id);
    }

    @GetMapping(path = Href.FOODS, produces = MIMEType.APPLICATION_JSON)
    public ResponseSuccess<SimpleFood> searchByFoodName(@RequestParam("name") String foodName) {
        return fatSecretWebAPI.searchFoods(foodName);
    }

    @GetMapping(path = Href.RECIPES, produces = MIMEType.APPLICATION_JSON)
    public ResponseSuccess<SimpleRecipe> searchByRecipeName(@RequestParam("name") String recipeName) {
        return fatSecretWebAPI.searchRecipes(recipeName);
    }
}