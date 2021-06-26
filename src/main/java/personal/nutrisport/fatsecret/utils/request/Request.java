package personal.nutrisport.fatsecret.utils.request;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Component
public class Request implements RequestContract {
    private final RequestBuilder requestBuilder;

    public Request() {
        requestBuilder = new RequestBuilder();
    }

    private JSONObject getJSONResponse(String apiURL) {
        JSONObject json = new JSONObject();
        try {
            URL url = new URL(apiURL);
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));
            while ((line = reader.readLine()) != null)
                builder.append(line);
            json.put("result", new JSONObject(builder.toString()));
        } catch (IOException e) {
            JSONObject error = new JSONObject();
            error.put("message", "There was an error in processing your request");
            json.put("error", error);
        }
        return json;
    }

    @Override
    public JSONObject searchFoods(String query, int pageNumber) {
        return getJSONResponse(requestBuilder.buildFoodsSearchUrl(query, pageNumber));
    }

    @Override
    public JSONObject searchRecipes(String query, int pageNumber) {
        return getJSONResponse(requestBuilder.buildRecipesSearchUrl(query, pageNumber));
    }

    @Override
    public JSONObject getFood(long id) {
        return getJSONResponse(requestBuilder.buildFoodGetUrl(id));
    }

    @Override
    public JSONObject getRecipe(long id) {
        return getJSONResponse(requestBuilder.buildRecipeGetUrl(id));
    }

}