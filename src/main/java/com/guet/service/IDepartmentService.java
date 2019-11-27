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
     * 查询所有的部门
     * @return 返回部门集合
     * @throws Exception
     */
    List<Department> findAll() throws Exception;
}
