package ml.sunmonkey.micropost.common;

public enum ServiceResultEnum {
    
    SUCCESS_MESSAGE("success"),
    ERROR_MESSAGE("error"),
    EMAIL_EXIST("email exist"),
    USER_NULL("user null"),
    EMAIL_OR_PASSWORD_ERROR("user or password error"),

    MESSAGE_NULL("content message is null");

    ServiceResultEnum(String s) {
    }
}
