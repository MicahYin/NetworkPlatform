package com.guet.dao;

import com.guet.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/10/17 21:27
 */
@Repository
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 根据用户ID查询用户的其他信息
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.guet.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    /**
     * 保存新用户到user表
     * @param user
     * @throws Exception
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo user) throws Exception;

    /**
     * 将用户所属的部门保存到department_user
     * @param user
     * @throws Exception
     */
    @Insert("insert into department_user(departmentId,userId) values(#{department},(SELECT id FROM users WHERE username=#{username}))")
    void saveUserDepartment(UserInfo user) throws Exception;

    @Select("select username from users")
    List<String> getAllUser() throws Exception;

}
