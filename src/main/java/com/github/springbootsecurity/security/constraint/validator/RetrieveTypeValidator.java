package com.github.springbootsecurity.security.constraint.validator;

import com.github.springbootsecurity.security.constraint.RetrieveType;
import com.github.springbootsecurity.security.retrieve.IRetrievePassword;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-06-16 17:41
 */

@RequiredArgsConstructor
public class RetrieveTypeValidator implements ConstraintValidator<RetrieveType, String> {

    private final Map<String, IRetrievePassword> map;

    @Override
    public boolean isValid(String type, ConstraintValidatorContext context) {
        return map.containsKey(type);
    }

}