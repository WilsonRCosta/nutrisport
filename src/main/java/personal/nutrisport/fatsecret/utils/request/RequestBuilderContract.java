package personal.nutrisport.fatsecret.utils.request;

public interface RequestBuilderContract {

    String buildFoodsSearchUrl(String query, int pageNumber);

    String buildFoodGetUrl(long id);

    String buildRecipesSearchUrl(String query, int pageNumber);

    String buildRecipeGetUrl(long id);
}
