package com.guet.service.impl;

import com.guet.dao.IUserDao;
import com.guet.domain.Role;
import com.guet.domain.UserInfo;
import com.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/10/17 21:27
 */
@Service("userService")
public class IUserServiceImp implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo=userDao.findByUsername(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role:roles){
            System.out.println(role.getRoleName());
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return null;
    }

    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return null;
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {

    }
}
