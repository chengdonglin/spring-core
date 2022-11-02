package com.dmai.springframework.beans.support;

import com.dmai.springframework.beans.BeansException;
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

    /**
     * 使用 bean 名称查询 BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定 BeanDefinition
     * @param beanName
     * @return
     */
    Boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的 bean 名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
