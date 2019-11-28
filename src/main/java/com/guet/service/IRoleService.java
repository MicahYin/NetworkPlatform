package com.guet.service;

import com.guet.domain.Role;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 16:22
 */
public interface IRoleService {
    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    List<Role> findAll(int page,int size) throws Exception;
}
