package personal.nutrisport.fatsecret.model;

public class Serving {
    private final long id;
    private final String
            description,
            url,
            unit,
            measureDesc;
    private final float
            amount,
            numOfUnits;
    private final NutritionTable nutrients;

    public Serving(long id, String description, String url, float amount, String unit, float numOfUnits,
                   String measureDesc, NutritionTable nutrients) {
        this.id = id;
        this.description = description;
        this.url = url;
        this.unit = unit;
        this.measureDesc = measureDesc;
        this.amount = amount;
        this.numOfUnits = numOfUnits;
        this.nutrients = nutrients;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUnit() {
        return unit;
    }

    public String getMeasureDesc() {
        return measureDesc;
    }

    public float getAmount() {
        return amount;
    }

    public float getNumOfUnits() {
        return numOfUnits;
    }

    public NutritionTable getNutrients() {
        return nutrients;
    }

    @Override
    public String toString() {
        return "Serving{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", unit='" + unit + '\'' +
                ", measureDesc='" + measureDesc + '\'' +
                ", amount=" + amount +
                ", numOfUnits=" + numOfUnits +
                ", nutrients=" + nutrients +
                '}';
    }
}
