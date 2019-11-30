package com.guet.service;

import com.guet.domain.Department;
import com.guet.domain.Role;
import com.guet.domain.UserInfo;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 14:43
 */

public interface IDepartmentService {
    /**
     * 分页查询所有的部门
     * @return 返回部门集合
     * @throws Exception
     */
    List<Department> findAll(int page,int size) throws Exception;

    /**
     * 新增部门
     * @param department
     * @throws Exception
     */
    void  save(Department department) throws Exception;

    /**
     * 不分页的查询所有部门
     * @return
     * @throws Exception
     */
    List<Department> findAll() throws Exception;

    List<String> getAllName() throws Exception;
}
