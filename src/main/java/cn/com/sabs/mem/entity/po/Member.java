package cn.com.sabs.mem.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * 会员
 */
@Data
public class Member {
    //id
    private String id;
    //姓名
    private String name;
    //电话
    private String telephone;
    //职业
    private String  profession;
    //微信号
    private String weiXinNum;
    //邀请人姓名
    private String inviterName;
    //创建时间
    private Date createTime;
    //最后一次修改时间
    private Date modifyTime;
    //创建人
    private String createId;
    //修改人
    private String modifyId;
    //备份字段
    private String bak1;
    //逻辑标识(删除：1；未删：0)
    private String isDel;

}
