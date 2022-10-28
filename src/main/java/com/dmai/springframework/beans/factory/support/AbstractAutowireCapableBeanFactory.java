package com.dmai.springframework.beans.factory.support;

import com.dmai.springframework.beans.factory.BeansException;
import com.dmai.springframework.beans.factory.config.BeanDefinition;

/**
 * <p>
 *  实例化 Bean 类
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:52:57
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            //todo 有构造器怎么处理
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new BeansException("instantiation of bean failed",exception);
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
