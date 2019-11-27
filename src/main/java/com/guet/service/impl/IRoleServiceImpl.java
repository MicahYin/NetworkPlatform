package com.guet.service.impl;

import com.guet.dao.IRoleDao;
import com.guet.domain.Role;
import com.guet.domain.UserInfo;
import com.guet.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 16:23
 */
@Service("roleService")
public class IRoleServiceImpl implements IRoleService{
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }
}
