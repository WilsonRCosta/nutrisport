package personal.nutrisport.fatsecret.model;

import personal.nutrisport.fatsecret.dto.NutritionTableDto;

import java.util.List;

public class Recipe {
    private final String name, url, description;
    private final long id;
    private final List<String> images;
    private final int rating, prepTime, cookTime;
    private final int numOfServings;
    private final NutritionTable nutritionTable;
    private final List<String> types;
    private final List<Category> categories;
    private final List<RecipeStep> steps;
    private final List<Ingredient> ingredients;

    public Recipe(String name, String url, String description, long id, List<String> images,
                  int rating, List<String> types, int numOfServings, int prepTime, int cookTime,
                  NutritionTable nutritionTable,
                  List<Category> categories, List<RecipeStep> steps, List<Ingredient> ingredients) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.id = id;
        this.images = images;
        this.rating = rating;
        this.types = types;
        this.numOfServings = numOfServings;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.categories = categories;
        this.nutritionTable = nutritionTable;
        this.steps = steps;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public List<String> getImages() {
        return images;
    }

    public int getRating() {
        return rating;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getNumOfServings() {
        return numOfServings;
    }

    public NutritionTable getNutritionTable() {
        return nutritionTable;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<RecipeStep> getSteps() {
        return steps;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", images=" + images +
                ", rating=" + rating +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", numOfServings=" + numOfServings +
                ", nutritionTable=" + nutritionTable +
                ", types=" + types +
                ", categories=" + categories +
                ", steps=" + steps +
                ", ingredients=" + ingredients +
                '}';
    }
}
