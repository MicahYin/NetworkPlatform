package com.guet.service;

import com.guet.domain.User;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/10/17 21:27
 */
public interface IUserService {
    public List<User> findAll();
}
