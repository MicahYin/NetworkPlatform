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
            @Result(property = "address",column = "address"),
            @Result(property = "departCharge",column = "departCharge"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "SecurityOfficer",column = "SecurityOfficer"),
            @Result(property = "SecurityOfficerPhone",column = "SecurityOfficerPhone"),
            @Result(property = "departType",column = "id",javaType = java.lang.String.class,one = @One(select = "com.guet.dao.IRoleDao.findRoleByDepartmentId"))
    })
    List<Department> findAll() throws Exception;

    /**
     * 新建部门，将部门数据插入到department表
     * @param department
     * @throws Exception
     */
    @Insert("insert into department(departName,address,departCharge,phone,SecurityOfficer,SecurityOfficerPhone) " +
            "values(#{departName},#{address},#{departCharge},#{phone},#{SecurityOfficer},#{SecurityOfficerPhone})")
    void save(Department department) throws Exception;

    /**
     * 保存部门的权限
     * @param department
     * @throws Exception
     */
    @Insert("insert into department_role(roleId,departmentId) values(#{departTypeStr},(SELECT id FROM department WHERE departName=#{departName})),(6,(SELECT id FROM department WHERE departName=#{departName}))")
    void saveDepartmentRole(Department department) throws Exception;
}
