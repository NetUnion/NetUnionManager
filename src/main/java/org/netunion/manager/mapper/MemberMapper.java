package org.netunion.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.netunion.manager.pojo.Member;

import java.util.List;

/**
 * 成员 Mapper 接口
 *
 * @author David Wang
 * @date 2022-07-06
 * @version 1.1
 */
@Mapper
public interface MemberMapper {
    //增
    public int add(Member member);
    //删
    public void delete(int id);
    //改
    public void update(Member member);
    public void updatePhoneNumById(int id, String phoneNum);
    public void updateBankNumById(int id, String bankNum);
    //查
    public List<Member> getAll();
    public Member getById(int id);

    public int count();
}
