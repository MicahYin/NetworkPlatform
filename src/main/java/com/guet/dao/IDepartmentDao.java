package com.guet.dao;

import com.guet.domain.Department;
import com.guet.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 15:16
 */
@Repository
public interface IDepartmentDao {
    @Select("select * from department")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "departName",column = "departName"),
            @Result(property = "departType",column = "id",javaType = java.lang.String.class,one = @One(select = "com.guet.dao.IRoleDao.findRoleByDepartmentId")),
            @Result(property = "address",column = "address"),
            @Result(property = "departCharge",column = "departCharge"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "SecurityOfficer",column = "SecurityOfficer"),
            @Result(property = "SecurityOfficerPhone",column = "SecurityOfficerPhone")
    })
    List<Department> findAll() throws Exception;
}
