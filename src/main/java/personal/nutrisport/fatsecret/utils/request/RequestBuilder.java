package personal.nutrisport.fatsecret.utils.request;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class RequestBuilder implements RequestBuilderContract {
    protected final static String
            APP_KEY,
            APP_SECRET,
            CLIENT_SECRET,
            APP_URL = "https://platform.fatsecret.com/rest/server.api",
            APP_SIGNATURE_METHOD = "HmacSHA1",
            APP_HTTP_METHOD = "GET";

    static {
        try (
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("CLIENT_AUTH.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))
        ) {
            APP_KEY = reader.readLine();
            APP_SECRET = reader.readLine();
            CLIENT_SECRET = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading CLIENT_AUTH.txt. Put your CONSUMER_KEY and CONSUMER_SECRET in resources folder.");
        }
    }

    private static String nonce() {
        Random r = new Random();
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < r.nextInt(8) + 2; i++)
            n.append(r.nextInt(26) + 'a');
        return n.toString();
    }

    private static List<String> generateOauthParams() {
        List<String> authParams = new ArrayList<>();
        authParams.add("oauth_consumer_key=" + APP_KEY);
        authParams.add("oauth_nonce=" + nonce());
        authParams.add("oauth_signature_method=HMAC-SHA1");
        authParams.add("oauth_timestamp=" + System.currentTimeMillis() / 1000);
        authParams.add("oauth_version=1.0");
        authParams.add("format=json");
        return authParams;
    }

    private static String encode(String url) {
        if (url == null) return "";
        return URLEncoder.encode(url, StandardCharsets.UTF_8)
                .replace("+", "%20")
                .replace("!", "%21")
                .replace("\\","%27")
                .replace("(", "%28")
                .replace(")", "%29")
                .replace("*", "%2A");
    }

    private static String normalizeParams(List<String> params) {
        Collections.sort(params);
        return String.join("&", params);
    }

    private static String buildOAuth(List<String> params) {
        String[] p = { APP_HTTP_METHOD, encode(APP_URL), encode(normalizeParams(params)) };
        String key = APP_SECRET + "&";
        String text = String.join("&", p);
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), APP_SIGNATURE_METHOD); //encode key
        String auth = "";
        try {
            Mac mac = Mac.getInstance(APP_SIGNATURE_METHOD);
            mac.init(secretKey);
            byte[] bytes = mac.doFinal(text.getBytes());
            auth = encode(new String(Base64.encode(bytes, Base64.DEFAULT)).trim());
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            System.err.println(e.getClass() + ": " + e.getMessage());
        }
        return auth;
    }

    private String buildSearchUrl(String method, String query, int pageNumber) {
        List<String> params = generateOauthParams();
        params.add("max_results=50");
        params.add("method=" + method);
        params.add("page_number=" + pageNumber);
        params.add("search_expression=" + encode(query));
        params.add("oauth_signature=" + buildOAuth(params));
        return APP_URL + "?" + normalizeParams(params);
    }

    private String buildGetUrl(String method, String idParam, long id) {
        List<String> params = generateOauthParams();
        params.add("method=" + method);
        params.add(idParam + "=" + id);
        params.add("oauth_signature=" + buildOAuth(params));
        return APP_URL + "?" + normalizeParams(params);
    }

    @Override
    public String buildFoodsSearchUrl(String query, int pageNumber) {
        return buildSearchUrl("foods.search", query, pageNumber);
    }

    @Override
    public String buildRecipesSearchUrl(String query, int pageNumber) {
        return buildSearchUrl("recipes.search", query, pageNumber);
    }

    @Override
    public String buildFoodGetUrl(long id) {
        return buildGetUrl("food.get.v2", "food_id", id);
    }

    @Override
    public String buildRecipeGetUrl(long id) {
        return buildGetUrl("recipe.get", "recipe_id", id);
    }
}
