package org.netunion.manager.controller;

import org.netunion.manager.config.Member;
import org.netunion.manager.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberTest {
    @Autowired MemberMapper memberMapper;

    @RequestMapping("/member/test/update")
    public String update() {
        Member eric = new Member();
        eric.setId(2);
        eric.setName("Eric");
        eric.setPhoneNum("13888888999");
        eric.setStudentId("2020050901001");
        memberMapper.update(eric);
        return "success";
    }
}
