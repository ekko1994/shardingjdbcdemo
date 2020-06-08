package com.atguigu.shardingjdbcdemo.entity;

import lombok.Data;

/**
 * @author zhanghao
 * @date 2020/6/2 - 22:05
 */
@Data
public class Course {
    private Long cid;
    private String cname;
    private Long userId;
    private String cstatus;

}
