package com.rxkj.hxg.freemark;

import com.rxkj.hxg.entity.Group;
import com.rxkj.hxg.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerTest {
	
	@Test
    public void test(){
        FreemarkerUtil util = new FreemarkerUtil();
        Map<String, Object> map = new HashMap<String, Object>();
 
        Group group = new Group();
        group.setName("IT");
         
        User user = new User();
        user.setId(Long.valueOf(001));
        user.setName("张三");
//        user.setAge(12);
//        user.setGroup(group);
         
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user);
        users.add(user);
         
        map.put("user", user);
//        map.put("users", users);
        //普通EL赋值
        //util.print("01.ftl", map );
        //判断
        //util.print("03.ftl", map, "03.html");
        //遍历
//        util.print("05.ftl", map);
        //子元素判断
        util.print("06.ftl", map);
    }
}
