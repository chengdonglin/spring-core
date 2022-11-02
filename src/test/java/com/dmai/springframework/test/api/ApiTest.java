package com.dmai.springframework.test.api;

import cn.hutool.core.io.IoUtil;
import com.dmai.springframework.beans.PropertyValue;
import com.dmai.springframework.beans.PropertyValues;
import com.dmai.springframework.beans.config.BeanDefinition;
import com.dmai.springframework.beans.config.BeanReference;
import com.dmai.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.dmai.springframework.beans.support.DefaultListableBeanFactory;
import com.dmai.springframework.core.io.DefaultResourceLoader;
import com.dmai.springframework.core.io.Resource;
import com.dmai.springframework.core.io.ResourceLoader;
import com.dmai.springframework.test.bean.UserDao;
import com.dmai.springframework.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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

    private ResourceLoader resourceLoader;

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

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:import.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }



    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件&注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取 bean 对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }
}
