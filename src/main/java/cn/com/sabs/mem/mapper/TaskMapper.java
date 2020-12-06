package cn.com.sabs.mem.mapper;

import cn.com.sabs.mem.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TaskMapper {
    List<Task> queryTaskByCondition(Map<String, Object> parameterMap);
}
