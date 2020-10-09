package app.cumt.login.form;

/**
 * @Author Fizz Pu
 * @Date 2020/10/7 上午11:40
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
public class LoginForm {
    private String email;
    private String psw;

    public LoginForm(){

    }

    public LoginForm(String email, String psw) {
        this.email = email;
        this.psw = psw;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }
}
