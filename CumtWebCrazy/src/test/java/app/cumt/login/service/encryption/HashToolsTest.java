package app.cumt.login.service.encryption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Fizz Pu
 * @Date 2020/10/6 下午8:10
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
class HashToolsTest {

    @Test
    void hashPsw() {
        System.out.println(HashTools.hashPsw("hfuwheu2323hsuefd"));
        System.out.println(HashTools.hashPsw("h"));
        System.out.println(HashTools.hashPsw(""));
        System.out.println(HashTools.hashPsw("123dadwdaassssssssssssssssssssssssssss"));
    }
}