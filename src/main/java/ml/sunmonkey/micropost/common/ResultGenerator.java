package ml.sunmonkey.micropost.common;

public class ResultGenerator<T> {

    private int SUCCESS_CODE = 200;
    private int ERROR_CODE = 400;
    private String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private String DEFAULT_ERROR_MESSAGE = "ERROR";

    public Result successResult(T data) {
        return new Result(SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, data);
    }

    public Result successResult() {
        return new Result(SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE);
    }

    public Result successResult(String message) {
        return new Result(SUCCESS_CODE, message);
    }

    public Result errorResult() {
        return new Result(ERROR_CODE, DEFAULT_ERROR_MESSAGE);
    }

    public Result errorResult(String message) {
        return new Result(ERROR_CODE, message);
    }
}
