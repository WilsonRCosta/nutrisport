package personal.nutrisport.fatsecret.model;

public class SimpleNutritionTable {
    private final float
            calories,
            carbohydrate,
            protein,
            fat;

    public SimpleNutritionTable(float calories, float carbohydrate, float protein, float fat) {
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }

    public float getCalories() {
        return calories;
    }

    public float getCarbohydrate() {
        return carbohydrate;
    }

    public float getProtein() {
        return protein;
    }

    public float getFat() {
        return fat;
    }

    @Override
    public String toString() {
        return "SimpleNutritionTable{" +
                "calories=" + calories +
                ", carbohydrate=" + carbohydrate +
                ", protein=" + protein +
                ", fat=" + fat +
                '}';
    }
}
