package com.example.handsomeblog.common.inner;

/**
 * 验证某个资源是否存在.
 *
 * @param <T> 参数类型.
 */
public interface IExistService<T> {

    /**
     * 验证某个资源是否存在 .
     *
     * @param id 资源标识
     * @return {@code true} 资源存在 {@code false}资源不存在
     */
    boolean exist(T id);
}
