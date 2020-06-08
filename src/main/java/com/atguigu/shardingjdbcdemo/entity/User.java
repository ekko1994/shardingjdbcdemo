package com.atguigu.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhanghao
 * @date 2020/6/3 - 11:26
 */
@Data
@TableName(value="t_user")
public class User {

    private  Long userId;
    private  String username;
    private  String ustatus;
}
