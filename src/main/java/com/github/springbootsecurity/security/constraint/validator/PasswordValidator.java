package com.github.springbootsecurity.security.constraint.validator;

import com.github.springbootsecurity.security.constraint.Password;
import com.github.springbootsecurity.security.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 石少东
 * @date 2020-06-16 17:41
 */

@RequiredArgsConstructor
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private final PasswordEncoder encoder;

    private final IUserRepository repository;

    @Override
    public boolean isValid(String rawPassword, ConstraintValidatorContext context) {
        String encodedPassword = repository.findCurrentPassword();
        return encoder.matches(rawPassword, encodedPassword);
    }

}