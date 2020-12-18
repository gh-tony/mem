package cn.com.sabs.mem.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * 任务
 */
@Data
public class Task {
    //任务编号
    private String taskId;
    //任务名称
    private String taskName;
    //任务状态(在审：0；通过：1；未通过：2)
    private String statu;
    //任务描述
    private String description;
    //创建时间
    private Date createTime;
    //创建人
    private String createId;
    //最后一次修改时间
    private Date modifyTime;
    //修改人
    private String modifyId;
    //逻辑标识(删除：1；未删：0)
    private String isDel;
    //审核人
    private String auditNo;
    //审核时间
    private Date auditTime;
    //审核意见
    private String auditOpinion;
}
