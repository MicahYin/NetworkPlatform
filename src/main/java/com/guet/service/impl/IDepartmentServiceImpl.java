package com.guet.service.impl;

import com.github.pagehelper.PageHelper;
import com.guet.dao.IDepartmentDao;
import com.guet.dao.IRoleDao;
import com.guet.domain.Department;
import com.guet.domain.Role;
import com.guet.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 14:44
 */
@Service("departmentService")
@Transactional
public class IDepartmentServiceImpl implements IDepartmentService{
    @Autowired
    private IDepartmentDao departmentDao;
    @Override
    public List<Department> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return departmentDao.findAll();
    }

    @Override
    public void save(Department department) throws Exception {
        departmentDao.save(department);
        departmentDao.saveDepartmentRole(department);
    }

    @Override
    public List<Department> findAll() throws Exception {
        return departmentDao.findAll();
    }

    @Override
    public List<String> getAllName(String userName) throws Exception {

        List<String> departNames = departmentDao.getAllDepart(userName);
        return departNames;
    }


    @Override
    public String getDepartNameByUsername(String userName) throws Exception {
       String departName = departmentDao.getDepartNameByUsername(userName);
        return departName;
    }
}
