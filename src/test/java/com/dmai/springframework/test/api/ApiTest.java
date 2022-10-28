package com.dmai.springframework.test.api;

import com.dmai.springframework.beans.factory.config.BeanDefinition;
import com.dmai.springframework.BeanFactory;
import com.dmai.springframework.beans.factory.support.DefaultListableBeanFactory;
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
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService)beanFactory.getBean("userService");

        userService.queryUserInfo();

        UserService userService_singleton = (UserService)beanFactory.getBean("userService");

        userService_singleton.queryUserInfo();
    }
}
