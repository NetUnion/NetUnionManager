package org.netunion.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.netunion.manager.pojo.Member;

import java.util.List;

/**
 * 成员 Mapper 接口
 *
 * @author David Wang
 * @date 2022-07-08
 * @version 2.0
 */
@Mapper
public interface MemberMapper {
    //增
    public int add(Member member);
    //删
    public void delete(String studentId);
    //改
    public void update(Member member);
    public void updatePhoneNumById(String studentId, String phoneNum);
    public void updateBankNumById(String studentId, String bankNum);
    //查
    public List<Member> getAll();
    public Member getById(String studentId);

    public int count();
}
