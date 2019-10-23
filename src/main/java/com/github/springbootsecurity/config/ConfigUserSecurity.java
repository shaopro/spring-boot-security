package com.github.springbootsecurity.config;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午8:34 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class ConfigUserSecurity extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows(Exception.class)
    protected void configure(@NotNull AuthenticationManagerBuilder auth) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    @SneakyThrows(Exception.class)
    protected void configure(@NotNull HttpSecurity http) {
        http
                // .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                // 使用表单登录
                .formLogin()
                // 指定登录页面
                // .loginPage("/sign_in")
                // 指定登录 URL
                // .loginProcessingUrl("/login_form")
                // .successHandler(successHandler)
                // .failureHandler(failureHandler)
                .and()
                .authorizeRequests()
                // 允许访问
                .antMatchers("/", "/session/invalid", "/register", "captcha").permitAll()
                // 任何请求均需授权
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .sessionManagement()
                .invalidSessionUrl("/session/invalid")
                .maximumSessions(2)
                .maxSessionsPreventsLogin(true)
                .expiredSessionStrategy(event -> event.getResponse().getWriter().write("并发登录!\n"))
                .and()
                .and().exceptionHandling().accessDeniedPage("/403")
        ;
        http.csrf().disable();

    }

    @Override
    @SneakyThrows(Exception.class)
    public void configure(@NotNull WebSecurity web) {
        web.ignoring().antMatchers("/static/js/**");
        web.ignoring().antMatchers("/static/css/**");
        web.ignoring().antMatchers("/static/image/**");
    }
}
