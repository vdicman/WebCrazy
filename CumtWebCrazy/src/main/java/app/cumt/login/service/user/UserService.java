package app.cumt.login.service.user;

import app.cumt.login.form.User;
import app.cumt.login.service.DataService.DataService;
import app.cumt.login.service.encryption.HashTools;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.spi.RegisterableService;

import org.apache.log4j.Logger;

import java.util.Queue;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 下午2:22
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */

@Component
public class UserService implements AbstractUserService {
    public static enum RegisterState{
        userNameRepeated, userEmailRepeated, registerSuccess
    }
    @Autowired
    DataService dataService;


    /**
     * 根据用户邮箱查找用户
     * @param email
     * @return
     */
    @Override
    public User searchUserByEmail(String email) {
        Session session = dataService.getSession();
        String hq = "from User where email = : email";
        Query<User> query = session.createQuery(hq);
        query.setParameter("email",  email);
        session.close();
        return query.uniqueResult();
    }

    public RegisterState register(User user) {
        // 密码hash
        user.setPassword(HashTools.hashPsw(user.getPassword()));
        Session session = dataService.getSession();
        // 检查是否注册过
        String checkUsername = "from User where username = : username";
        String checkEamil = "from User where email = : email";
        Query<User> queryUsername = session.createQuery(checkUsername), queryEamil = session.createQuery(checkEamil);
        queryUsername.setParameter("userName", user.getUsername());
        queryEamil.setParameter("email", user.getEmail());
        if(queryUsername.uniqueResult() != null)return RegisterState.userEmailRepeated;
        if(queryEamil.uniqueResult() != null)return RegisterState.userEmailRepeated;
        // 保存
        Transaction ts = session.beginTransaction();
        session.save(user);
        ts.commit();
        session.close();
        return RegisterState.registerSuccess;
    }

    @Override
    public User logout() {
        return null;
    }

    @PostConstruct
    void init(){
       System.out.println("UserService完成装配");
    }
}
