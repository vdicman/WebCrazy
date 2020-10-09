package app.cumt.login.ctrol;

import app.cumt.login.form.LoginForm;
import app.cumt.login.form.User;
import app.cumt.login.service.encryption.Jwt;
import app.cumt.login.service.user.LoginState;
import app.cumt.login.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @Author Fizz Pu
 * @Date 2020/10/5 下午5:13
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */


// 1.路径写在类上面，就不可达了
// 2. 参数或取失败
// 3. 请求与响应乱码问题

@RestController
@RequestMapping(produces = "application/json;charset=utf8")
public class LoginControl {
    @Autowired
    UserService userService;

    // @RequestParam 参数总结
    @RequestMapping(value = "/cumt/web/login", method = RequestMethod.POST)
    public String getLogin(@RequestBody LoginForm form) {
        String format = "{\"code\":%d, \"msg\":%s,\"token\":%s, \"refreshtoken\":%s}";
        String response, token, refreshToken;
        LoginState state = userService.login(form);
        // 1. 校验参数是否为null
        if (state == LoginState.ParaError) {
            response  = String.format(format, 0, "未获得参数name或者email", "", "");
        }
        // 2. 未注册
        else if (state == LoginState.LoginNotRegister) {
            response = String.format(format, 1, "未注册", "", "");
        }
        // 3. 密码错误
        else if (state == LoginState.LoginPswIncorrect) {
            response = String.format(format,2, "密码错误", "", "");
        }
        // 4 帐号，密码正确，签发token, refreshToken
        else{
             User user = userService.searchUserByEmail(form.getEmail());
             token = Jwt.getToken(user.getId());
             refreshToken = Jwt.getRefreshToken(user.getId());
             response = String.format(format, 200, "登录成功", token, refreshToken);
        }
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegister(@RequestBody User user) {
        String format =  "{\"code\":%s, \"msg\":%s,\"token\":%s, \"refreshtoken\":%s}", response="";
        String token="", refreshToken="";
        switch (userService.register(user)){
            case registerSuccess -> {
                token = Jwt.getToken(user.getId());
                token = Jwt.getRefreshToken(user.getId());
                response = String.format(format, 200, "注册成功", token, refreshToken);
            }case userNameRepeated -> {
                response = String.format(format, 0, "用户名已经注册", token, refreshToken);
            } case userEmailRepeated -> {
                response = String.format(format, 1, "邮箱已被注册", token, refreshToken);
            }
        }
        return response;
    }

    @PostConstruct
    void init(){
        System.out.println("LoginControl初始化成功");
    }
}
