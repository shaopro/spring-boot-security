package com.github.springbootsecurity.event.handler;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.EventListener;
import org.springframework.security.access.event.AuthorizedEvent;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 下午1:15 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class AuthorizedEventListener {

    @EventListener
    public void event1(@NotNull AuthorizedEvent event) {
        log.error("AuthorizedEventListener 接收到事件:{}", event.getClass());
    }


}
