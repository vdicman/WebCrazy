package app.cumt.login.ctrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 下午8:00
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */

@RestController
public class Login {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "{\"name\":\"fizz\"}";
    }

    @PostConstruct
    void init(){
        System.out.println("Login控制器初始化成功");
    }
}
