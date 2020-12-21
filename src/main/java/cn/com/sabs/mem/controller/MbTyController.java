package cn.com.sabs.mem.controller;

import cn.com.sabs.mem.entity.dto.MemberRequestDto;
import cn.com.sabs.mem.entity.dto.MemberResponseDto;
import cn.com.sabs.mem.entity.dto.TaskDto;
import cn.com.sabs.mem.entity.po.Member;
import cn.com.sabs.mem.model.ReturnResult;
import cn.com.sabs.mem.model.RtnResponse;
import cn.com.sabs.mem.service.MemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用于thymeleaf开发
 */
@Controller
@RequestMapping("/member")
@Slf4j
public class MbTyController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/toMemberAdd")
    public String toTaskAdd(ModelMap map){
        Member member = new Member();
        map.addAttribute("member",member);
        log.info("toMemberTask");
        return "thymeleaf/member/memberAdd";
    }
    @RequestMapping("/queryMemberByCondition")
    public ModelAndView queryByCondition(MemberRequestDto memberRequestDto, @RequestParam(defaultValue = "1")int pageNumber,
                                         @RequestParam(defaultValue = "5")int pageSize){
        ModelAndView modelAndView = new ModelAndView("thymeleaf/member/memberList");
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        parameterMap.put("memberName",memberRequestDto.getName());
        try {
            PageHelper.startPage(pageNumber,pageSize);
            List<MemberResponseDto> memberList = memberService.queryMemberByCondition(parameterMap);
            PageInfo<MemberResponseDto> pageInfo = new PageInfo<MemberResponseDto>(memberList);
            log.info(">>>>>>>>>>>memberList size=" + memberList.size());
            modelAndView.addObject("pageInfo",pageInfo);
            modelAndView.addObject("memberRequestDto",memberRequestDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return modelAndView;
    }


    @RequestMapping("/addMember")
    public String addMember(Member member){
        try {
            memberService.addMember(member);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "redirect:/member/queryMemberByCondition";
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
