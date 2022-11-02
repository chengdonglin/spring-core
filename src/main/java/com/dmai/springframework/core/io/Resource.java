package com.dmai.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 资源加载接口定义
 * </p>
 *
 * @author linchengdong
 * @since 2022-11-02 14:53:48
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
