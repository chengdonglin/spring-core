package com.dmai.springframework.core.io;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 16:24:38
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
