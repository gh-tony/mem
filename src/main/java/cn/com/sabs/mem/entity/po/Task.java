package cn.com.sabs.mem.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * 任务
 */
//@Data
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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyId() {
        return modifyId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getAuditNo() {
        return auditNo;
    }

    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }
}
