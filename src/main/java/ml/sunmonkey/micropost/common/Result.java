package ml.sunmonkey.micropost.common;

import lombok.Data;

@Data
public class Result<T> {

    private int resultCode;
    private String message;
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message, T data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public Result(String message) {
        this.message = message;
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
