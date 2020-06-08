package com.atguigu.shardingjdbcdemo;

import com.atguigu.shardingjdbcdemo.entity.Course;
import com.atguigu.shardingjdbcdemo.entity.Udict;
import com.atguigu.shardingjdbcdemo.entity.User;
import com.atguigu.shardingjdbcdemo.mapper.CourseMapper;
import com.atguigu.shardingjdbcdemo.mapper.UdictMapper;
import com.atguigu.shardingjdbcdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UdictMapper udictMapper;

    //====================测试公共表===================//
    @Test
    void addUdict(){
        Udict udict = new Udict();
        udict.setUstatus("a");
        udict.setUvalue("已启用");
        udictMapper.insert(udict);
    }

    @Test
    void delUdict(){
        QueryWrapper<Udict> wrapper = new QueryWrapper<Udict>();
        wrapper.eq("dictid",474964022777610241L);
        udictMapper.delete(wrapper);
    }

    //===================垂直分库===================//
    @Test
    void addUser(){
        User user = new User();
        user.setUsername("rose");
        user.setUstatus("b");
        userMapper.insert(user);
    }

    @Test
    void findUser(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",475017048674533377L);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    //===================水平分库====================//
    @Test
    void addCourseDB(){
        Course course = new Course();
        course.setCname("javademo");
        //分库根据user_id
        course.setUserId(111L);
        course.setCstatus("Normal");
        courseMapper.insert(course);
    }

    @Test
    void findCourseDB(){
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",100L);
        wrapper.eq("cid",474892912748920833L);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }

    //=================水平分表=================//
    //添加课程的方法
    @Test
    void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("java"+i);
            course.setUserId(100L);
            course.setCstatus("Normal"+i);
            courseMapper.insert(course);
        }

    }

    //查询课程的方法
    @Test
    void findCourse(){
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid",474876014774714369L);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }


}
