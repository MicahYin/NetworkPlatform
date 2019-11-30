package com.guet.service.impl;

import com.guet.dao.IDataDisplayDao;
import com.guet.service.IDataDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MicahYin
 * @date 2019/11/30 11:47
 */
@Service
public class IDataDisplayServiceImpl implements IDataDisplayService{
    @Autowired
    private IDataDisplayDao dataDisplayDao;
    @Override
    public int findDataStatusZero() throws Exception {
        return dataDisplayDao.findDataStatusZero();
    }

    @Override
    public int findDataStatusOne() throws Exception {
        return dataDisplayDao.findDataStatusOne();
    }
}
