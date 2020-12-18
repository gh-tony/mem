package cn.com.sabs.mem.service;

import cn.com.sabs.mem.entity.dto.MemberResponseDto;
import cn.com.sabs.mem.entity.dto.TaskDto;
import cn.com.sabs.mem.entity.po.Member;
import cn.com.sabs.mem.entity.po.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MemberService {
    List<MemberResponseDto> queryMemberByCondition(Map<String, Object> parameterMap) throws Exception;
    void addMember(Member member) throws Exception;
    void updateMember(Member member) throws Exception;
    void deleteMemberByCondition(Map<String, Object> parameterMap) throws Exception;
}
