package com.github.springbootsecurity.security.core.handler;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功以后会调用这里
 *
 * <p>
 * 创建时间为 下午11:33 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
//@Configuration
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private static final RedirectStrategy STRATEGY = new DefaultRedirectStrategy();

    @Override
    @SneakyThrows(IOException.class)
    public void onAuthenticationSuccess(@NotNull HttpServletRequest httpServletRequest,
                                        @NotNull HttpServletResponse httpServletResponse,
                                        @NotNull Authentication authentication) {
        log.info("-------------------- 登录成功 --------------------");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write("success!");
        String targetUrl = httpServletRequest.getRequestURI();
        STRATEGY.sendRedirect(httpServletRequest, httpServletResponse, targetUrl);
    }
}
