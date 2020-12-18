package cn.com.sabs.mem.controller;

import cn.com.sabs.mem.entity.dto.MemberResponseDto;
import cn.com.sabs.mem.entity.dto.MemberRequestDto;
import cn.com.sabs.mem.entity.po.Member;
import cn.com.sabs.mem.model.ReturnResult;
import cn.com.sabs.mem.model.RtnResponse;
import cn.com.sabs.mem.service.MemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
@Slf4j
public class MbController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/queryMemberByCondition")
    public ReturnResult<PageInfo<MemberResponseDto>> queryByCondition(@RequestBody MemberRequestDto memberRequestDto){
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        parameterMap.put("memberName",memberRequestDto.getName());
        try {
            PageHelper.startPage(memberRequestDto.getPageNum(),memberRequestDto.getPageSize());
            List<MemberResponseDto> memberList = memberService.queryMemberByCondition(parameterMap);
            PageInfo<MemberResponseDto> pageInfo = new PageInfo<MemberResponseDto>(memberList);
            log.info(">>>>>>>>>>>memberList size=" + memberList.size());
            return RtnResponse.makeOKRsp(pageInfo);
        }catch (Exception e){
            log.error(e.getMessage());
            return RtnResponse.makeErrRsp("查询异常，请重新查询");
        }
    }


    @RequestMapping("/addMember")
    public ReturnResult<MemberResponseDto> addMember(@RequestBody Member member){
        try {
            memberService.addMember(member);
            return RtnResponse.makeOKRsp();
        }catch (Exception e){
            log.error(e.getMessage());
            return RtnResponse.makeErrRsp("新增异常，请重新添加");
        }
    }

    @RequestMapping("/updateMember")
    public ReturnResult<MemberResponseDto> updateMember(@RequestBody Member member){
        try {
            memberService.updateMember(member);
            return RtnResponse.makeOKRsp();
        }catch (Exception e){
            log.error(e.getMessage());
            return RtnResponse.makeErrRsp("更新异常，请重新操作");
        }
    }

    @RequestMapping("/deleteMemberByCondition")
    public ReturnResult<MemberResponseDto> deleteMemberByCondition(){
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        try {
            memberService.deleteMemberByCondition(parameterMap);
            return RtnResponse.makeOKRsp();
        }catch (Exception e){
            log.error(e.getMessage());
            return RtnResponse.makeErrRsp("删除异常，请重新删除");
        }
    }

}
