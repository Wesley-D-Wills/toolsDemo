package com.hello.springboothello.annotations.validators;

import com.hello.springboothello.annotations.TelephoneNumber;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneNumberValidator implements ConstraintValidator<TelephoneNumber, String> {

    private static final String REGEX_TEL = "0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}|13[0-9]\\d{8}|15[1089]\\d{8}";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_TEL);
        Matcher m = p.matcher(s);
        return m.find();//boolean
    }
}
