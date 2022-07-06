package org.netunion.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.netunion.manager.config.Member;

import java.util.List;

/**
 * 成员 Mapper 接口
 *
 * @author David Wang
 * @date 2022-07-06
 * @version 1.0
 */
@Mapper
public interface MemberMapper {
    //增
    public int add(Member member);
    //删
    public void delete(int id);
    //改
    public int update(Member member);
    public void updatePhoneNumById(int id, String phoneNum);
    //查
    public List<Member> getAll();
    public Member getById(int id);

    public int count();
}
