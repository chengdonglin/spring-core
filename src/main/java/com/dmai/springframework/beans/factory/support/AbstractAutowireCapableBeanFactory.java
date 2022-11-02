package com.dmai.springframework.beans.factory.support;

import com.dmai.springframework.beans.factory.BeansException;
import com.dmai.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * <p>
 *  实例化 Bean 类
 * </p>
 *
 * @author linchengdong
 * @since 2022-10-28 17:52:57
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean = null;
        try {
            //todo 有构造器怎么处理
            bean = createBeanInstance(beanDefinition,beanName,args);
        } catch (Exception exception) {
            throw new BeansException("instantiation of bean failed",exception);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName,Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            if (null != args && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
