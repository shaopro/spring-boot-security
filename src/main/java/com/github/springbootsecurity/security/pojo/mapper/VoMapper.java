package com.github.springbootsecurity.security.pojo.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>
 * 创建时间为 下午7:49 2020/5/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class VoMapper {

    private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    private static final MapperFacade MAPPER_FACADE = MAPPER_FACTORY.getMapperFacade();

    public static <D, V> V mapper(D d, Class<V> clz) {
        return MAPPER_FACADE.map(d, clz);
    }

    public static <D, V> V mapper(D d, Class<D> clz1, Class<V> clz2, @NotNull Map<String, String> map) {
        ClassMapBuilder<D, V> classMapBuilder = MAPPER_FACTORY.classMap(clz1, clz2);
        AtomicReference<ClassMapBuilder<D, V>> reference = new AtomicReference<>(classMapBuilder);
        map.forEach((k, v) -> reference.set(reference.get().field(k, v)));
        reference.get().byDefault().register();
        return MAPPER_FACADE.map(d, clz2);
    }
}