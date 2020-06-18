package com.github.springbootsecurity.security.constraint.validator;

import com.github.springbootsecurity.security.constraint.UniqueMobile;
import com.github.springbootsecurity.security.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 石少东
 * @date 2020-06-16 17:41
 */

@RequiredArgsConstructor
public class UniqueMobileValidator implements ConstraintValidator<UniqueMobile, String> {

    private final IUserRepository repository;

    @Override
    public boolean isValid(String mobile, ConstraintValidatorContext context) {
        return !repository.existsByMobile(mobile);
    }

}