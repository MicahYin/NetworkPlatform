package com.guet.service.impl;

import com.github.pagehelper.PageHelper;
import com.guet.dao.ISysLogDao;
import com.guet.domain.SysLog;
import com.guet.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/28 10:34
 */
@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService{
    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}
