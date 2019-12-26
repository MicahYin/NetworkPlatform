package com.guet.service.impl;

import com.guet.dao.IDataDisplayDao;
import com.guet.service.IDataDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/30 11:47
 */
@Service
public class IDataDisplayServiceImpl implements IDataDisplayService{
    @Autowired
    private IDataDisplayDao dataDisplayDao;
    @Override
    public int findDataStatusZero(String userName) throws Exception {
        Integer zero = dataDisplayDao.findDataStatusZero(userName);
        if(zero==null) {return 0;}
        return dataDisplayDao.findDataStatusZero(userName);
    }

    @Override
    public int findDataStatusOne(String userName) throws Exception {
        Integer one = dataDisplayDao.findDataStatusZero(userName);
        if(one==null) {return 0;}
        return dataDisplayDao.findDataStatusOne(userName);
    }

    @Override
    public int findDataTwo(String userName) throws Exception {
        Integer two = dataDisplayDao.findDataStatusZero(userName);
        if(two==null) {return 0;}
        return dataDisplayDao.findDataTwo(userName);

    }

    @Override
    public int findDataThree(String userName) throws Exception {
        Integer three = dataDisplayDao.findDataStatusZero(userName);
        if(three==null) {return 0;}
        return dataDisplayDao.findDataThree(userName);

    }
}
