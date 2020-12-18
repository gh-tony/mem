package cn.com.sabs.mem.service.impl;

import cn.com.sabs.mem.entity.dto.TaskDto;
import cn.com.sabs.mem.entity.po.Task;
import cn.com.sabs.mem.mapper.TaskMapper;
import cn.com.sabs.mem.service.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void addTask(Task task) throws Exception {
        taskMapper.addTask(task);
    }

    @Override
    public void updateTask(Task task) throws Exception {
        taskMapper.updateTask(task);
    }

    @Override
    public void deleteTaskByCondition(Map<String, Object> parameterMap) throws Exception {
        taskMapper.deleteTaskByCondition(parameterMap);
    }

    @Override
    public List<TaskDto> queryTaskByCondition(Map<String, Object> parameterMap) throws Exception {
        List<TaskDto> taskDtoList = new ArrayList<TaskDto>();
        List<Task> taskList = taskMapper.queryTaskByCondition(parameterMap);
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()){
            TaskDto taskDto = new TaskDto();
            BeanUtils.copyProperties(iterator.next(),taskDto);
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
    }



}
