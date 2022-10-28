package com.dmai.springframework.beans.factory.config;

/**
 * <p>
 *  单例注册
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:42:18
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
