package com.dmai.springframework.beans.support;

import com.dmai.springframework.beans.config.BeanDefinition;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:56:56
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表注册 beanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
