package personal.nutrisport.common;

public class Common {

    public static class MIMEType {

        public static final String
            APPLICATION_JSON = "application/json";
    }

    public static class Href {

        public static final String
                HOME = "/api",
                FAT_SECRET = "/fatsecret",

                FOODS = "/foods",
                RECIPES = "/recipes",
                FOOD = "/foods/{id}",
                RECIPE = "/recipe/{id}";
    }
}
