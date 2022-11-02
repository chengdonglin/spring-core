package com.dmai.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 11:16:15
 */
public class UserDao {

    private static Map<String,String> hashMap = new HashMap<>();
    static {
        hashMap.put("1001","hlx");
        hashMap.put("1002","klp");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
