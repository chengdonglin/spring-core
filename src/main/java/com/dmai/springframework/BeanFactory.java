package com.dmai.springframework;

import com.dmai.springframework.beans.factory.BeansException;
import com.dmai.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:20:16
 */
public interface BeanFactory {




    Object getBean(String name) throws BeansException;


    Object getBean(String name,Object... args) throws BeansException;

}
