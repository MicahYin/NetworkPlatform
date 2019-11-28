package com.guet.service;

import com.guet.domain.SysLog;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/7/26 19:30
 */
public interface ISysLogService {
    public void save(SysLog sysLog)throws Exception;

    public List<SysLog> findAll(int page,int size)throws Exception;
}
