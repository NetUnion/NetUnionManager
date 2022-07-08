package org.netunion.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.netunion.manager.pojo.User;

import java.util.List;

/**
 * 用户 Mapper 接口
 *
 * @author David Wang
 * @date 2020-07-08
 * @version 2.0
 */
@Mapper
public interface UserMapper {
    //增
    int add(User user);
    //删
    void delete(String username);
    //改
    void updatePasswordByUsername(String username, String newPassword);
    void updateAuthorityByUsername(String username, String newAuthority);
    //查
    User getByUsername(String username);
    List<User> getAll();
}
