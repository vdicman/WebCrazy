package app.cumt.login.service.user;

import app.cumt.login.form.LoginForm;
import app.cumt.login.form.User;
import app.cumt.login.service.DataService.DataService;
import app.cumt.login.service.encryption.HashTools;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 下午2:22
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */

@Component
public class UserService implements AbstractUserService {

    @Autowired
    DataService dataService;

    @Override
    public LoginState login(LoginForm loginForm){
        // 参数检查
        Session session = dataService.getSession();
        String hq = "from User where email = : email";
        Query<User> query = session.createQuery(hq);
        query.setParameter("email",  loginForm.getEmail());
        User user;

        // 0.参数异常
        if(loginForm.getEmail() == null || loginForm.getPsw() == null){
            return LoginState.ParaError;
        }
        // 1. 未注册
        else if ((user = query.uniqueResult()) == null) {
            return LoginState.LoginNotRegister;
        }
        // 3. 密码错误
        else if (!user.getPassword().equals(HashTools.hashPsw(loginForm.getPsw()))) {
            return  LoginState.LoginPswIncorrect;
        }
        // 4 帐号，密码正确
        else{
            return LoginState.LoginSuccess;
        }
    }


    /**
     * 根据用户邮箱查找用户
     * @param email
     * @return
     */
    public User searchUserByEmail(String email) {
        Session session = dataService.getSession();
        String hq = "from User where email = : email";
        Query<User> query = session.createQuery(hq);
        query.setParameter("email",  email);
        User res = query.uniqueResult();
        session.close();
        return res;
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
        else if(queryEamil.uniqueResult() != null)return RegisterState.userEmailRepeated;
        else {
            Transaction ts = session.beginTransaction();
            session.save(user);
            ts.commit();
            session.close();
            return RegisterState.registerSuccess;
        }
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
