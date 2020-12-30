package cn.com.sabs.mem.mapper;

import cn.com.sabs.mem.entity.po.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TaskMapper {
    Task queryTaskById(@Param("taskId") String taskId) throws Exception;
    List<Task> queryTaskByCondition(Map<String, Object> parameterMap) throws Exception;
    void addTask(Task task) throws Exception;
    void updateTask(Task task) throws Exception;
    void deleteTaskByCondition(Map<String, Object> parameterMap) throws Exception;
}
