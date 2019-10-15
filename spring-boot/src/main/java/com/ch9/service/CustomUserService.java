/**
 * 文件名: CustomUserService.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.service;

import com.ch9.dao.SysUserRepository;
import com.ch9.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-12 10:09
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserRepository userRepository;

    /**
     *  重写loadUserByUsername方法
     *
     * @param s 用户名
     * @return 返回数据给spring security使用
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUser user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
