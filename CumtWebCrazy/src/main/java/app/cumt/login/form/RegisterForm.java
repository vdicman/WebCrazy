package app.cumt.login.form;

/**
 * @Author Fizz Pu
 * @Date 2020/10/7 下午12:17
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
public class RegisterForm {
    private String name;
    private String psw;
    private String email;
    private String sex;
    private String url;

    public String getName() {
        return name;
    }

    public String getPsw() {
        return psw;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getUrl() {
        return url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RegisterForm(String name, String psw, String email, String sex, String url) {
        this.name = name;
        this.psw = psw;
        this.email = email;
        this.sex = sex;
        this.url = url;
    }


}
