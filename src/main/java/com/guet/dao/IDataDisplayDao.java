package com.guet.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author MicahYin
 * @date 2019/11/30 11:17
 */
@Repository
public interface IDataDisplayDao {
    /**
     * 查询0的个数
     * @return
     * @throws Exception
     */
    @Select("SELECT COUNT(STATUS) FROM event WHERE status=0")
    int findDataStatusZero() throws Exception;

    /**
     * 查询1的个数
     * @return
     * @throws Exception
     */
    @Select("SELECT COUNT(STATUS) FROM event WHERE status=1")
    int findDataStatusOne() throws Exception;
}
