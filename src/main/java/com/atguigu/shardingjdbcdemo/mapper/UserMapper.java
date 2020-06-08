package com.atguigu.shardingjdbcdemo.mapper;

import com.atguigu.shardingjdbcdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhanghao
 * @date 2020/6/3 - 11:27
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
