package com.guet.dao;

import com.guet.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/28 10:30
 */
@Repository
public interface ISysLogDao {
    /**
     * 保存登录日志
     * @param sysLog
     * @throws Exception
     */
    @Insert("insert into syslog(visitTime,username,ip) values(#{visitTime},#{username},#{ip})")
    void save(SysLog sysLog)throws Exception;

    /**
     * 查询登录日志
     * @return
     */
    @Select("select * from syslog")
    List<SysLog> findAll();
}
