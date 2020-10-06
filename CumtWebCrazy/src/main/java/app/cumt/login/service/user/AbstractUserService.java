package app.cumt.login.service.user;

import app.cumt.login.form.User;

/**
 * @Author Fizz Pu
 * @Date 2020/10/4 上午12:51
 * @Version 1.0
 * 失之毫厘，缪之千里！
 */
public interface AbstractUserService {
    /**
     * 根据用户邮箱搜索用户
     * @return User对象
     */
    User searchUserByEmail(String email);

    /**
     * 用户登出
     * @return User对象
      */
    User logout();



}
