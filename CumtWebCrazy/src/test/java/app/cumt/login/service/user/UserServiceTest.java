package app.cumt.login.service.user;

import app.AppConfig;
import app.cumt.login.form.LoginForm;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 下午2:28
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */


public class UserServiceTest {

    @Test
    public void testLogin(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = ioc.getBean(UserService.class);
    }

}