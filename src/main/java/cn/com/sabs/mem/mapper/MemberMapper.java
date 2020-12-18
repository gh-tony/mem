package cn.com.sabs.mem.mapper;


import cn.com.sabs.mem.entity.po.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberMapper {
    List<Member> queryMemberByCondition(Map<String, Object> parameterMap) throws Exception;
    void addMember(Member member) throws Exception;
    void updateMember(Member member) throws Exception;
    void deleteMemberByCondition(Map<String, Object> parameterMap) throws Exception;
}
