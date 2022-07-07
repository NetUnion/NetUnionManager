package org.netunion.manager.controller;

import org.netunion.manager.config.Member;
import org.netunion.manager.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 成员页面控制器
 *
 * @author David Wang
 * @version 1.2
 * @date 2020-07-07
 */
@RestController
public class MemberController {
    @Autowired
    MemberMapper memberMapper;
    // 获取所有成员信息 JSON 格式
    @GetMapping("/member")
    public List<Member> getMemberList() {
        return memberMapper.getAll();
    }
    // 获取指定成员信息 JSON 格式
    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable("id") int id) {
        return memberMapper.getById(id);
    }
    //通过 POST 方式添加成员
    @PostMapping(value = "/member/add", produces = "application/json;charset=UTF-8")
    public String addMember(@RequestBody Member member) {
        memberMapper.add(member);
        return "添加成员成功";
    }
    //通过 DELETE 方式删除成员
    @DeleteMapping(value = "/member/delete/{id}")
    public String deleteMember(@PathVariable("id") int id) {
        memberMapper.delete(id);
        return "删除成员成功";
    }
    //通过 POST 方式更新成员银行卡号
    @PostMapping(value = "/member/update/bank")
    public String updateMemberBankNum(@RequestParam int id, @RequestParam String bankNum) {
        memberMapper.updateBankNumById(id, bankNum);
        return "更新成员银行卡号成功";
    }
    //通过 POST 方式更新成员手机号码
    @PostMapping(value = "/member/update/phone")
    public String updateMemberPhoneNum(@RequestParam int id, @RequestParam String phoneNum) {
        memberMapper.updatePhoneNumById(id, phoneNum);
        return "更新成员手机号码成功";
    }
}
