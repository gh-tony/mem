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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用于thymeleaf开发
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
    public String login(User user){
        if((user.getName()!=null && user.getName().trim().equals("admin"))
            && (user.getPwd()!=null && user.getPwd().trim().equals("admin"))){
            ModelAndView modelAndView = new ModelAndView("thymeleaf/index");
            return "thymeleaf/index";
        }else{
            return "login";
        }

    }
}
