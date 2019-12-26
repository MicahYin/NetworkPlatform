package com.guet.service.impl;

import com.github.pagehelper.PageHelper;
import com.guet.dao.IUserDao;
import com.guet.domain.Role;
import com.guet.domain.SysLog;
import com.guet.domain.UserInfo;
import com.guet.service.ISysLogService;
import com.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/10/17 21:27
 */
@Service("userService")
@Transactional
public class IUserServiceImp implements IUserService {
    @Autowired
    private ISysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

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
        //记录登录日志
        SysLog sysLog=new SysLog();
        Date visitTime=new Date();
        sysLog.setVisitTime(visitTime);
        sysLog.setUsername(s);
        //获取访问的ip地址
        String ip = request.getRemoteAddr();
        sysLog.setIp(ip);
        try {
            sysLogService.save(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
        userDao.saveUserDepartment(user);
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

    @Override
    public List<String> getAllUser(String userName) throws Exception {
        List<String> users = userDao.getAllUser(userName);
        return users;
    }


}
