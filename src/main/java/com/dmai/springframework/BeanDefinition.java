package com.dmai.springframework;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:18:13
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
