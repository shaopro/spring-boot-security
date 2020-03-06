package com.github.springbootsecurity.security.service.common;

import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 创建时间为 下午4:48 2020/3/1
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICommonUserService {

    Page<SystemUserDO> findAll(Pageable pageable, SystemUserDO authentication);

    SystemUserDO findById(Long userId);

    SystemUserDO save(SystemUserDO systemUser, SystemUserDO authentication);

    SystemUserDO update(SystemUserDO systemUser, SystemUserDO authentication);

    void deleteById(Long userId);


}