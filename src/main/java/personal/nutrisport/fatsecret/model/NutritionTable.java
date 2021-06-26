package personal.nutrisport.fatsecret.model;

public class NutritionTable {
    private final float
            calories,
            carbohydrate,
            protein,
            fat,
            saturatedFat,
            polyunsaturatedFat,
            monounsaturatedFat,
            transFat,
            cholesterol,
            sodium,
            potassium,
            fiber,
            sugar,
            vitaminA,
            vitaminC,
            vitaminD,
            calcium,
            iron,
            added_sugars;

    public NutritionTable(float calories, float carbohydrate, float protein, float fat,
                          float saturatedFat, float polyunsaturatedFat, float monounsaturatedFat,
                          float transFat, float cholesterol, float sodium, float potassium,
                          float fiber, float sugar, float vitaminA, float vitaminC, float vitaminD,
                          float calcium, float iron, float added_sugars) {
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.saturatedFat = saturatedFat;
        this.polyunsaturatedFat = polyunsaturatedFat;
        this.monounsaturatedFat = monounsaturatedFat;
        this.transFat = transFat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.potassium = potassium;
        this.fiber = fiber;
        this.sugar = sugar;
        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;
        this.vitaminD = vitaminD;
        this.calcium = calcium;
        this.iron = iron;
        this.added_sugars = added_sugars;
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

    public float getSaturatedFat() {
        return saturatedFat;
    }

    public float getPolyunsaturatedFat() {
        return polyunsaturatedFat;
    }

    public float getMonounsaturatedFat() {
        return monounsaturatedFat;
    }

    public float getTransFat() {
        return transFat;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public float getSodium() {
        return sodium;
    }

    public float getPotassium() {
        return potassium;
    }

    public float getFiber() {
        return fiber;
    }

    public float getSugar() {
        return sugar;
    }

    public float getVitaminA() {
        return vitaminA;
    }

    public float getVitaminC() {
        return vitaminC;
    }

    public float getCalcium() {
        return calcium;
    }

    public float getIron() {
        return iron;
    }

    public float getAdded_sugars() {
        return added_sugars;
    }

    public float getVitaminD() {
        return vitaminD;
    }

    public float getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "NutritionTable{" +
                "calories=" + calories +
                ", carbohydrate=" + carbohydrate +
                ", protein=" + protein +
                ", fat=" + fat +
                ", saturatedFat=" + saturatedFat +
                ", polyunsaturatedFat=" + polyunsaturatedFat +
                ", monounsaturatedFat=" + monounsaturatedFat +
                ", transFat=" + transFat +
                ", cholesterol=" + cholesterol +
                ", sodium=" + sodium +
                ", potassium=" + potassium +
                ", fiber=" + fiber +
                ", sugar=" + sugar +
                ", vitaminA=" + vitaminA +
                ", vitaminC=" + vitaminC +
                ", vitaminD=" + vitaminD +
                ", calcium=" + calcium +
                ", iron=" + iron +
                ", added_sugars=" + added_sugars +
                '}';
    }
}
