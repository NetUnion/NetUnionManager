package org.netunion.manager.controller;

import org.netunion.manager.mapper.MemberMapper;
import org.netunion.manager.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 成员页面控制器
 *
 * @author David Wang
 * @version 2.0
 * @date 2020-07-08
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
    @GetMapping("/member/{studentId}")
    public String getMember(@PathVariable("studentId") String studentId) {
        if (memberMapper.getById(studentId) == null) return "{\"error\": \"NO MEMBER\"}";
        else return memberMapper.getById(studentId).toString();
    }
    //通过 POST 方式添加成员
    @PostMapping(value = "/member/add", produces = "application/json;charset=UTF-8")
    public String addMember(@RequestBody Member member) {
        memberMapper.add(member);
        return member.toString();
    }
    //通过 DELETE 方式删除成员
    @DeleteMapping(value = "/member/delete/{studentId}")
    public String deleteMember(@PathVariable("studentId") String studentId) {
        Member member = memberMapper.getById(studentId);
        if (member != null){
            memberMapper.delete(studentId);
            return member.toString();
        }
        else {
            return "{\"error\": \"NO MEMBER\"}";
        }
    }
    //通过 POST 方式更新成员银行卡号
    @PostMapping(value = "/member/update/bank")
    public String updateMemberBankNum(@RequestParam String studentId, @RequestParam String bankNum) {
        Member member = memberMapper.getById(studentId);
        if (member == null) {
            return "{\"error\": \"NO MEMBER\"}";
        }
        else {
            memberMapper.updateBankNumById(studentId, bankNum);
            return member.toString();
        }
    }
    //通过 POST 方式更新成员手机号码
    @PostMapping(value = "/member/update/phone")
    public String updateMemberPhoneNum(@RequestParam String studentId, @RequestParam String phoneNum) {
        Member member = memberMapper.getById(studentId);
        //判空
        if (member == null) {
            return "{\"error\": \"NO MEMBER\"}";
        }
        else {
            memberMapper.updatePhoneNumById(studentId, phoneNum);
            return member.toString();
        }
    }
}
