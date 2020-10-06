package app;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 上午12:52
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */

@Configuration
@ComponentScan // 自动搜索当前类所在的包和所在的子包
@EnableWebMvc  // 激活mvc
public class AppConfig {

    /**
     * 创建第三方Bean,生成数据库管理对象
     * @return
     */
    @Bean(name="Hibernate")
    SessionFactory createSessionFactory(){
        org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
        return config.configure().buildSessionFactory();
    }

}
