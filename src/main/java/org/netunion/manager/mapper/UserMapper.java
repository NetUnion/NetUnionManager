package org.netunion.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.netunion.manager.pojo.User;

import java.util.List;

/**
 * 用户 Mapper 接口
 *
 * @author David Wang
 * @date 2020-07-07
 * @version 1.0
 */
@Mapper
public interface UserMapper {
    //增
    public int add(User user);
    //删
    public void delete(int id);
    //改
    public void update(User user);
    public void updatePasswordById(int id, String oldPassWord, String newPassWord);
    //查
    public User getById(int id);
    public User getByUserName(String userName);
    public List<User> getAll();
}
