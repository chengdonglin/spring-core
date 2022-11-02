package com.dmai.springframework.beans.factory;

import com.dmai.springframework.beans.BeansException;
import com.dmai.springframework.beans.config.AutowireCapableBeanFactory;
import com.dmai.springframework.beans.config.BeanDefinition;
import com.dmai.springframework.beans.config.ConfigurableBeanFactory;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 17:12:14
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
