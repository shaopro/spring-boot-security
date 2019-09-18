package com.github.springbootsecurity.service;

import com.github.springbootsecurity.pojo.UserBookDO;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午8:10 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserBookService {

    UserBookDO findBookByBookName(String name);


    List<UserBookDO> findAllBooks();
}
