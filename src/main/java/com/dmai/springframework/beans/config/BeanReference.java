package com.dmai.springframework.beans.config;

/**
 * <p>
 *  Bean 的引用
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 11:11:47
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
