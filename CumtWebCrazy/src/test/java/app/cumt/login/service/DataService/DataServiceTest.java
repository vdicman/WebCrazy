//package app.cumt.login.service.DataService;
//
//import app.AppConfig;
//import app.cumt.login.form.User;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @Author Fizz Pu
// * @Date 2020/10/4 下午4:41
// * @Version 1.0
// * 失之毫厘，缪之千里！
// */
//public class DataServiceTest {
//
//    @Test
//    public void test1(){
//        // 完成装配
//        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
//        DataService dataService = ioc.getBean(DataService.class);
//        User user = new User();
//        user.setEmail("122321");
//        user.setIs_superuser(0);
//        user.setPassword("fhuew");
//        user.setSex("男");
//        user.setPhoto("fhuehwuf");
//        user.setUsername("fizz");
//        Session session = dataService.getSession();
//        // 开启事务
//        Transaction tc = session.beginTransaction();
//
//        session.save(user);
//        // 提交
//
//        tc.commit();
//        //关闭session
//
//        session.close();
//    }
//}