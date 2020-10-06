package app.cumt.login.ctrol;

import app.cumt.login.form.User;
import app.cumt.login.service.encryption.HashTools;
import app.cumt.login.service.encryption.Jwt;
import app.cumt.login.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Fizz Pu
 * @Date 2020/10/5 下午5:13
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */

@RestController("/cumt/web")
public class LoginControl {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLogin(@RequestParam("email") String email, @RequestParam("psw") String psw) {
        String format = "{\"code\":%s, \"msg\":%s,\"token\":%s, \"refreshtoken\":%s}";
        String response, token, refreshToken;
        User user = userService.searchUserByEmail(email);

        // 1. 校验参数是否为null
        if (email == null || psw == null) {
            response  = String.format(format, 0, "未获得参数name或者email", "", "");
        }
        // 2. 未注册
        else if (user == null) {
            response = String.format(format, 1, "未注册", "", "");
        }
        // 3. 密码错误
        else if (!user.getPassword().equals(HashTools.hashPsw(psw))) {
            response = String.format(format,2, "密码错误", "", "");
        }
        // 4 帐号，密码正确，签发token, refreshToken
        else{
             token = Jwt.getToken(user.getId());
             refreshToken = Jwt.getRefreshToken(user.getId());
             response = String.format(format, 200, "登录成功", token, refreshToken);
        }
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegister(User user) {
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

}
