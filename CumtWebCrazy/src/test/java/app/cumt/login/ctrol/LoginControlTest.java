package app.cumt.login.ctrol;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Fizz Pu
 * @Date 2020/10/6 下午9:56
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
class LoginControlTest {
     static HttpClient httpClient;

    @BeforeAll
    public static void  init(){
        httpClient = HttpClient.newBuilder().build();
    }


    @Test
    void getLogin() throws URISyntaxException, IOException, InterruptedException {
        String url = "http://localhost:9090/cumt/web/login";
        String body = "\"email\"=\"123\"@qq.com&\"psw\"=\"12312\"";
        HttpRequest request = HttpRequest.newBuilder(new URI(url)).POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String s = response.body();
        System.out.println(s);
    }

    @Test
    void getRegister() {
    }
}