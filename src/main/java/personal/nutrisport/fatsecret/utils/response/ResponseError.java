package personal.nutrisport.fatsecret.utils.response;

public class ResponseError<T> {
    private final int code;
    private final String message;

    public ResponseError(int code, String message) {

        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
