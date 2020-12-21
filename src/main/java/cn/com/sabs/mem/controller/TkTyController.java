package cn.com.sabs.mem.controller;

import cn.com.sabs.mem.entity.dto.TaskDto;
import cn.com.sabs.mem.entity.dto.TaskRequestDto;
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
@RequestMapping("/task")
@Slf4j
public class TkTyController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/toTaskAdd")
    public String toTaskAdd(ModelMap map){
        TaskDto task = new TaskDto();
        map.addAttribute("task",task);
        log.info("toAddTask");
        return "thymeleaf/task/taskAdd";
    }
    @GetMapping("/queryTaskByCondition")
    public ModelAndView queryByCondition(TaskDto taskDto,@RequestParam(defaultValue = "1")int pageNumber,
                                         @RequestParam(defaultValue = "5")int pageSize){
        ModelAndView modelAndView = new ModelAndView("thymeleaf/task/taskList");
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        log.info("taskName>>>>>>"+taskDto.getTaskName());
        parameterMap.put("taskName",taskDto.getTaskName());
        try {
            PageHelper.startPage(pageNumber,pageSize);
            List<TaskDto> taskList = taskService.queryTaskByCondition(parameterMap);
            PageInfo<TaskDto> pageInfo = new PageInfo<TaskDto>(taskList);
            log.info(">>>>>>>>>>>taskList size=" + taskList.size());

            modelAndView.addObject("taskList",taskList);
            modelAndView.addObject("pageInfo",pageInfo);
            modelAndView.addObject("taskDto",taskDto);
        }catch (Exception e){
            log.error(e.getMessage());

        }

        return modelAndView;
        //"thymeleaf/task/taskList"
    }


    @PostMapping("/addTask")
    public String addTask(Task task){
        try {
            log.info(task.getTaskName()+".................");
            taskService.addTask(task);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "redirect:/task/queryTaskByCondition";
    }

    @RequestMapping("/updateTask")
    public ReturnResult<List<TaskDto>> updateTask(@RequestBody Task task){
        try {
            taskService.updateTask(task);
            return RtnResponse.makeOKRsp();
        }catch (Exception e){
            log.error(e.getMessage());
            return RtnResponse.makeErrRsp("更新异常，请重新操作");
        }
    }

    @RequestMapping("/deleteTaskByCondition")
    public ReturnResult<List<TaskDto>> deleteTaskByCondition(){
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        try {
            taskService.deleteTaskByCondition(parameterMap);
            return RtnResponse.makeOKRsp();
        }catch (Exception e){
            log.error(e.getMessage());
            return RtnResponse.makeErrRsp("删除异常，请重新删除");
        }
    }


}
