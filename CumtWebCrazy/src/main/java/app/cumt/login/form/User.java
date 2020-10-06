package app.cumt.login.form;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 上午12:50
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
public class User {
    private int id;
    private String username;
    private String password; // hash摘要
    private String email;
    private int is_superuser;
    private String sex;
    private String photo;

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIs_superuser(int is_superuser) {
        this.is_superuser = is_superuser;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getIs_superuser() {
        return is_superuser;
    }

    public String getSex() {
        return sex;
    }

    public String getPhoto() {
        return photo;
    }
}
