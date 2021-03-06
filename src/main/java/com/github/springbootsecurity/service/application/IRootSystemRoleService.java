package com.github.springbootsecurity.service.application;

import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import com.github.springbootsecurity.pojo.vo.SystemRoleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 创建时间为 下午3:17 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IRootSystemRoleService {

    Page<SystemRoleVO> findAllRoles(Pageable pageable);

    SystemRoleVO saveRole(SystemRoleDO systemRoleDO);

    SystemRoleVO updateRole(SystemRoleDO systemRoleDO);

    void deleteRole(long roleId);

}
