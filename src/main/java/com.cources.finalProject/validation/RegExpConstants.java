package com.cources.finalProject.validation;

public interface RegExpConstants {
    String EMAIL_VALID_REGEXP = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    String LOGIN_VALID_REGEXP = "^[a-z0-9_-]{3,15}$";
}
