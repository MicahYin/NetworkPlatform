package com.guet.service.impl;

import com.guet.dao.IUserDao;
import com.guet.domain.User;
import com.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/10/17 21:27
 */
@Service("userService")
public class IUserServiceImp implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
