package cn.com.sabs.mem.controller;

import cn.com.sabs.mem.entity.dto.TaskDto;
import cn.com.sabs.mem.entity.dto.User;
import cn.com.sabs.mem.entity.po.Task;
import cn.com.sabs.mem.model.ReturnResult;
import cn.com.sabs.mem.model.RtnResponse;
import cn.com.sabs.mem.service.TaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户登录
 */
@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if(user.getName()!=null && !"admin".equals(user.getName())){
            modelAndView.addObject("error","无此用户！");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if(user.getPwd()!=null && !"admin".equals(user.getPwd())){
            modelAndView.addObject("error","密码错误！");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.addObject("name",user.getName());
        modelAndView.setViewName("thymeleaf/index");
        return modelAndView;
    }
}
