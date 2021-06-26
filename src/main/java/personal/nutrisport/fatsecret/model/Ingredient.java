package personal.nutrisport.fatsecret.model;

public class Ingredient {
    private final long foodID, servingID;
    private final String
        description,
        name,
        url,
        measureDesc;
    private final float numOfUnits;

    public Ingredient(long foodID, long servingID, String description,
                      String name, String url, String measureDesc, float numOfUnits) {
        this.foodID = foodID;
        this.servingID = servingID;
        this.description = description;
        this.name = name;
        this.url = url;
        this.measureDesc = measureDesc;
        this.numOfUnits = numOfUnits;
    }

    public long getFoodID() {
        return foodID;
    }

    public long getServingID() {
        return servingID;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getMeasureDesc() {
        return measureDesc;
    }

    public float getNumOfUnits() {
        return numOfUnits;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "foodID=" + foodID +
                ", servingID=" + servingID +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", measureDesc='" + measureDesc + '\'' +
                ", numOfUnits=" + numOfUnits +
                '}';
    }
}
