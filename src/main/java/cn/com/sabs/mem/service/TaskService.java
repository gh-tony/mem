package cn.com.sabs.mem.service;

import cn.com.sabs.mem.entity.dto.TaskDto;
import cn.com.sabs.mem.entity.po.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TaskService {
    Task queryTaskById(String taskId) throws Exception;
    List<TaskDto> queryTaskByCondition(Map<String, Object> parameterMap) throws Exception;
    void addTask(Task task) throws Exception;
    void updateTask(Task task) throws Exception;
    void deleteTaskByCondition(Map<String, Object> parameterMap) throws Exception;
}
