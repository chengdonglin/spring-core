package com.dmai.springframework.test.bean;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:22:43
 */
public class UserService {

    private String uId;

    private UserDao userDao;


    public void queryUserInfo() {
        System.out.println("查询用户信息" + userDao.queryUserName(uId));
    }
}
