package personal.nutrisport.fatsecret.model;

import java.util.List;

public class Food {
    private final long id;
    private final String name, url, type;
    private final List<Serving> servings;

    public Food(long id, String name, String url, String type, List<Serving> servings) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.type = type;
        this.servings = servings;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public List<Serving> getServings() {
        return servings;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", servings=" + servings +
                '}';
    }
}
