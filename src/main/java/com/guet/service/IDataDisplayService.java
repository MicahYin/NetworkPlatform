package com.guet.service;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/30 11:45
 */
public interface IDataDisplayService {
    int findDataStatusZero(String userName) throws Exception;
    int findDataStatusOne(String userName) throws Exception;
    int findDataTwo(String userName) throws Exception;
    int findDataThree(String userName) throws Exception;
}
