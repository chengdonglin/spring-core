package com.dmai.springframework.util;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 14:56:55
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return  cl;
    }
}
