/**
 * 文件名: SysUserRepository.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.dao;

import com.ch9.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-12 10:06
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);
}
