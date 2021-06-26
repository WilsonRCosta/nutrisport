package personal.nutrisport.fatsecret.model;

public class RecipeStep {
    private final int number; // the order of the step
    private final String description; // instruction of the step

    public RecipeStep(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "RecipeStep{" +
                "number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
