package com.guet.dao;

import com.guet.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/9 16:52
 */
@Repository
public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findPermissionByRoleId(String id)throws Exception;
}
