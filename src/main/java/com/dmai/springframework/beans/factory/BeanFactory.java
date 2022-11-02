package com.dmai.springframework.beans.factory;

import com.dmai.springframework.beans.BeansException;

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

    <T> T getBean(String name,Class<T> requiredType) throws BeansException;

}
