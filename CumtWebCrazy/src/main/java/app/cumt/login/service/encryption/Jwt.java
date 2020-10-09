package app.cumt.login.service.encryption;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.util.Date;
import java.util.Locale;


/**
 * @Author Fizz Pu
 * @Date 2020/10/6 下午7:50
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
public class Jwt {
    public  String getToken(int id, int minutes) {
        // 后面从配置文件读取
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            var build = JWT.create();
            // 写入id
            build.withClaim("id", id);
            // 生效时间15分钟
            // 传入的参数是当前时间加两个小时
            build.withExpiresAt();
        } catch (JWTCreationException ex) {
            ex.printStackTrace();
        }
        return token;
    }

}
