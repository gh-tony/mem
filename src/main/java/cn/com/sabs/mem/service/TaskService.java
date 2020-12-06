package cn.com.sabs.mem.service;

import cn.com.sabs.mem.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TaskService {
    List<Task> queryTaskByCondition(Map<String, Object> parameterMap);
}
