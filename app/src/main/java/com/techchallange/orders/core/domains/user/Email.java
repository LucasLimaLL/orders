package com.techchallange.orders.core.domains.user;

import com.techchallange.orders.core.exceptions.ValidationException;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Email {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);
    private final String email;

    public Email(String email) {
        if (!PATTERN.matcher(email).matches()) {
            throw new ValidationException("Email is not valid");
        }

        this.email = email;
    }
}
