package cn.com.sabs.mem.service.impl;

import cn.com.sabs.mem.mapper.TaskMapper;
import cn.com.sabs.mem.model.Task;
import cn.com.sabs.mem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public List<Task> queryTaskByCondition(Map<String, Object> parameterMap) {
        return null;
    }
}
