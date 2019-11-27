package com.guet.service.impl;

import com.guet.dao.IDepartmentDao;
import com.guet.dao.IRoleDao;
import com.guet.domain.Department;
import com.guet.domain.Role;
import com.guet.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 14:44
 */
@Service("departmentService")
public class IDepartmentServiceImpl implements IDepartmentService{
    @Autowired
    private IDepartmentDao departmentDao;
    @Override
    public List<Department> findAll() throws Exception {
        return departmentDao.findAll();
    }
}
