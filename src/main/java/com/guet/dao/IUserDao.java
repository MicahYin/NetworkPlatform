package com.guet.dao;

import com.guet.domain.User;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/10/17 21:27
 */
@Repository
public interface IUserDao {
    public List<User> findAll();;
}
