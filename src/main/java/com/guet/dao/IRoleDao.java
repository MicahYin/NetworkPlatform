package com.guet.dao;

import com.guet.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/9 16:41
 */
@Repository
public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.guet.dao.IPermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(String id) throws Exception;
}