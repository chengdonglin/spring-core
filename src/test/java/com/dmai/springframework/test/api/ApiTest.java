package com.dmai.springframework.test.api;

import com.dmai.springframework.beans.PropertyValue;
import com.dmai.springframework.beans.PropertyValues;
import com.dmai.springframework.beans.config.BeanDefinition;
import com.dmai.springframework.beans.config.BeanReference;
import com.dmai.springframework.beans.support.DefaultListableBeanFactory;
import com.dmai.springframework.test.bean.UserDao;
import com.dmai.springframework.test.bean.UserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","1002"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService)beanFactory.getBean("userService","dmai");

        userService.queryUserInfo();

    }


    @Test
    public void testMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("1",2);
        map.put("1",new ArrayList<>());
        System.out.println(map);
    }
}
