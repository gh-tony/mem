package cn.com.sabs.mem.service.impl;

import cn.com.sabs.mem.entity.dto.MemberRequestDto;
import cn.com.sabs.mem.entity.dto.MemberResponseDto;
import cn.com.sabs.mem.entity.dto.TaskDto;
import cn.com.sabs.mem.entity.po.Member;
import cn.com.sabs.mem.entity.po.Task;
import cn.com.sabs.mem.mapper.MemberMapper;
import cn.com.sabs.mem.mapper.TaskMapper;
import cn.com.sabs.mem.service.MemberService;
import cn.com.sabs.mem.service.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void addMember(Member member) throws Exception {
        memberMapper.addMember(member);
    }

    @Override
    public void updateMember(Member member) throws Exception {
        memberMapper.updateMember(member);
    }

    @Override
    public void deleteMemberByCondition(Map<String, Object> parameterMap) throws Exception {
        memberMapper.deleteMemberByCondition(parameterMap);
    }

    @Override
    public List<MemberResponseDto> queryMemberByCondition(Map<String, Object> parameterMap) throws Exception {
        List<MemberResponseDto> memberResponseDtoList = new ArrayList<MemberResponseDto>();
        List<Member> memberList = memberMapper.queryMemberByCondition(parameterMap);
        Iterator<Member> iterator = memberList.iterator();
        while (iterator.hasNext()){
            MemberResponseDto memberResponseDto = new MemberResponseDto();
            BeanUtils.copyProperties(iterator.next(),memberResponseDto);
            memberResponseDtoList.add(memberResponseDto);
        }
        return memberResponseDtoList;
    }



}
