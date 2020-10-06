package app.cumt.login.service.DataService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 下午3:02
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */

@Component
public class DataService {
    // 自动注入
    @Autowired
    @Qualifier("Hibernate") // 注入名称为Hibernate的bean
    SessionFactory  dataSource = null;

    public SessionFactory getDataSource() {
        return dataSource;
    }

    public void setDataSource(SessionFactory dataSource) {
        this.dataSource = dataSource;
    }


    public Session getSession(){
        return dataSource.openSession();
    }

    @PostConstruct
    public void init(){
        System.out.println("DataService初始化成功");
    }

    // ioc容器关闭时，清理资源
    @PreDestroy
    public void close(){
        dataSource.close();
    }
}
