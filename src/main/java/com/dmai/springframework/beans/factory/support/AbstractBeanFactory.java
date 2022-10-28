package com.dmai.springframework.beans.factory.support;

import com.dmai.springframework.BeanFactory;
import com.dmai.springframework.beans.factory.BeansException;
import com.dmai.springframework.beans.factory.config.BeanDefinition;
import com.dmai.springframework.beans.factory.config.DefaultSingletonBeanRegistry;

/**
 * <p>
 *  抽象类定义模板方法
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:44:51
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeansException;
}
