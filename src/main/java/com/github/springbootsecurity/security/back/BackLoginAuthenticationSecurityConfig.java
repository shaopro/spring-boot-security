package com.github.springbootsecurity.security.back;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 下午8:44 2019/12/1
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
@RequiredArgsConstructor
public class BackLoginAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final AuthenticationFailureHandler failureHandler;

    private final AuthenticationSuccessHandler successHandler;

    private final UserDetailsService userDetailsService;

    private final ApplicationEventPublisher publisher;

    @Override
    public void configure(@NotNull HttpSecurity http) {
        SessionAuthenticationStrategy sessionAuthenticationStrategy = http.getSharedObject(SessionAuthenticationStrategy.class);
        BackLoginCodeAuthenticationFilter backLoginCodeAuthenticationFilter = new BackLoginCodeAuthenticationFilter();
        backLoginCodeAuthenticationFilter.setApplicationEventPublisher(publisher);
        backLoginCodeAuthenticationFilter.setSessionAuthenticationStrategy(sessionAuthenticationStrategy);
        backLoginCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        backLoginCodeAuthenticationFilter.setAuthenticationFailureHandler(failureHandler);
        backLoginCodeAuthenticationFilter.setAuthenticationSuccessHandler(successHandler);

        BackLoginAuthenticationProvider backLoginAuthenticationProvider = new BackLoginAuthenticationProvider();
        backLoginAuthenticationProvider.setUserDetailsService(userDetailsService);
        http.authenticationProvider(backLoginAuthenticationProvider).addFilterAfter(backLoginCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}





