package com.example.handsomeblog.common.inner;

/**
 * 验证某个资源是否存在.
 *
 * @param <T> 参数类型.
 * @param <R> 返回对像类型.
 */
public interface IFindService<T, R> {

    /**
     * 查找某个对像资源 .
     *
     * @param id 资源标识
     * @return 当对像不存在时，返回 {@code null}
     */
    R find(T id);
}
