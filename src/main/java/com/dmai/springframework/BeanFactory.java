package com.dmai.springframework;

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
public class BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name,beanDefinition);
    }
}
