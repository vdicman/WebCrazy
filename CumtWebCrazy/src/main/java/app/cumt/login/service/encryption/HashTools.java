package app.cumt.login.service.encryption;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Fizz Pu
 * @Date 2020/10/6 下午7:44
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
public class HashTools {
    /**
     * 采用
     * @param psw
     * @return
     */
    public static String hashPsw(String psw){
        // 生成随机盐值
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
            SecretKey key = keyGen.generateKey();
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(key);
            mac.update(psw.getBytes(StandardCharsets.UTF_8));
            return new BigInteger(1, mac.doFinal()).toString();
        } catch (NoSuchAlgorithmException | InvalidKeyException ex){
            throw new RuntimeException("密码hash错误");
        }
    }
}
