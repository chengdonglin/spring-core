package com.dmai.springframework.beans.factory.support;

import com.dmai.springframework.beans.factory.BeansException;
import com.dmai.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * <p>
 *  定义实例化策略接口
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-01 13:58:31
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,Object[] args) throws BeansException;
}
