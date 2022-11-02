package com.dmai.springframework.beans;

/**
 * <p>
 *  定义属性
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 10:41:19
 */
public class PropertyValue {

    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
