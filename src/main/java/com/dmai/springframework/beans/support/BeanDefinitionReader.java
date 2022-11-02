package com.dmai.springframework.beans.support;

import com.dmai.springframework.beans.BeansException;
import com.dmai.springframework.core.io.Resource;
import com.dmai.springframework.core.io.ResourceLoader;

/**
 * <p>
 * bean定义读取接口
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 16:32:27
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
