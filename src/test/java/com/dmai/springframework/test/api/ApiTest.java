package com.dmai.springframework.test.api;

import com.dmai.springframework.BeanDefinition;
import com.dmai.springframework.BeanFactory;
import com.dmai.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:23:24
 */
public class ApiTest {


    @Test
    public void testBeanFactory() {
        // 1. 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        // 3. 获取 bean
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
