package personal.nutrisport.fatsecret.model;

public class SimpleRecipe {
    private final String name, url, description;
    private final long id;
    private final SimpleNutritionTable nutritionTable;

    public SimpleRecipe(String name, String url, String description, long id, SimpleNutritionTable nutritionTable) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.id = id;
        this.nutritionTable = nutritionTable;
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

    public SimpleNutritionTable getNutritionTable() {
        return nutritionTable;
    }

    @Override
    public String toString() {
        return "SimpleRecipe{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", nutritionTable=" + nutritionTable +
                '}';
    }
}
