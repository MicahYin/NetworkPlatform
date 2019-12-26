package com.guet.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    /*@Select("SELECT COUNT(STATUS) FROM event WHERE status=0")*/
    @Select("select Count(progress) from event WHERE progress = '未处理' and publisher = #{userName}")
    int findDataStatusZero(String userName) throws Exception;

    /**
     * 查询1的个数
     * @return
     * @throws Exception
     */
    /*@Select("SELECT COUNT(STATUS) FROM event WHERE status=1")*/
    @Select("select Count(progress) from event WHERE progress = '正在处理'and publisher = #{userName}")
    int findDataStatusOne(String userName) throws Exception;

    @Select("select Count(progress) from event WHERE progress = '已通报' and publisher = #{userName}")
    int findDataTwo(String userName);

    @Select("select Count(progress) from event WHERE progress = '已处理' and publisher = #{userName}")
    int findDataThree(String userName);
}
