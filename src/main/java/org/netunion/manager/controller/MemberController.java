package org.netunion.manager.controller;

import org.netunion.manager.config.Member;
import org.netunion.manager.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 成员页面控制器
 *
 * @author David Wang
 * @date 2020-07-06
 * @version 1.0
 */
@RestController
public class MemberController {
    @Autowired MemberMapper memberMapper;
    @RequestMapping("/member")
    public String getMember() {
        StringBuilder name = new StringBuilder();
        List<Member> members = memberMapper.getAll();
        for (Member member : members) {
            name.append(member.getName());
        }
        return name.toString();
    }
}
