package com.dmai.springframework.beans.support;

import cn.hutool.core.bean.BeanUtil;
import com.dmai.springframework.beans.BeansException;
import com.dmai.springframework.beans.PropertyValue;
import com.dmai.springframework.beans.PropertyValues;
import com.dmai.springframework.beans.config.BeanDefinition;
import com.dmai.springframework.beans.config.BeanReference;

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
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            //todo 有构造器怎么处理
            bean = createBeanInstance(beanDefinition,beanName,args);
            // 给 bean 填充属性
            applyPropertyValues(beanName,bean,beanDefinition);
        } catch (Exception exception) {
            throw new BeansException("instantiation of bean failed",exception);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // A 依赖 B ， 获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values:" + beanName);
        }
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
