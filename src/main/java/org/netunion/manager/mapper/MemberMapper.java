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
    public int add(Member member);

    public void delete(int id);

    public Member getById(int id);

    public int update(Member member);

    public List<Member> getAll();

    public int count();
}
