package cn.com.sabs.mem.controller;

import cn.com.sabs.mem.model.Task;
import cn.com.sabs.mem.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/task")
@Slf4j
public class TkController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/addTask")
    public void addTask(Task task){
        log.info("addTask start.......");
    }
    @RequestMapping("/em")
    public void exmple(){
        log.info("addTask start.......");
    }





}
