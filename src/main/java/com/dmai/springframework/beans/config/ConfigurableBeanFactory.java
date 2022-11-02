package com.dmai.springframework.beans.config;

import com.dmai.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 17:15:23
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
