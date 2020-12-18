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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
@Slf4j
public class TkController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/queryTaskByCondition")
    public ReturnResult<PageInfo<TaskDto>> queryByCondition(@RequestBody TaskRequestDto taskRequestDto){
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        parameterMap.put("taskName",taskRequestDto.getTaskName());
        try {
            PageHelper.startPage(taskRequestDto.getPageNum(),taskRequestDto.getPageSize());
            List<TaskDto> taskList = taskService.queryTaskByCondition(parameterMap);
            PageInfo<TaskDto> pageInfo = new PageInfo<TaskDto>(taskList);
            log.info(">>>>>>>>>>>taskList size=" + taskList.size());
            return RtnResponse.makeOKRsp(pageInfo);
        }catch (Exception e){
            log.error(e.getMessage());
            return RtnResponse.makeErrRsp("查询异常，请重新查询");
        }
    }


    @RequestMapping("/addTask")
    public ReturnResult<List<TaskDto>> addTask(@RequestBody Task task){
        try {
            taskService.addTask(task);
            return RtnResponse.makeOKRsp();
        }catch (Exception e){
            log.error(e.getMessage());
            return RtnResponse.makeErrRsp("新增异常，请重新添加");
        }
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
