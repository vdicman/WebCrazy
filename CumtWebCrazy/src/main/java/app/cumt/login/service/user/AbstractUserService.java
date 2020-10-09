package app.cumt.login.service.user;

import app.cumt.login.form.LoginForm;
import app.cumt.login.form.RegisterForm;
import app.cumt.login.form.User;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 上午12:51
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
public interface AbstractUserService {

    /**
     * 用户登出
     * @return User对象
      */
    User logout();

    /**
     * 注册
     * @return userNameRepeated:用户名已被注册 userEmailRepeated:用户邮箱已被注册 , registerSuccess: 注册成功
     */
    RegisterState register(User user);


    /**
     * 用户登录
     * @return LoginNotRegister : 帐号未注册, LoginPswIncorrect: 密码错误, LoginSuccess: 登录成功
     */
    LoginState login(LoginForm loginForm);

}
