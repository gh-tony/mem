package cn.com.sabs.mem.entity.dto;

import lombok.Data;

/**
 * @ClassName
 * @Description TODO
 * @Author Tony
 * @Date 2020/12/17 17:00
 * Version 1.0
 */
@Data
public class MemberRequestDto {
    private int pageNum;
    private int pageSize;
    private String name;
}
