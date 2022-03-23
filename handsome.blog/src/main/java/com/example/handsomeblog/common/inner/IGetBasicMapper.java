package com.example.handsomeblog.common.inner;

import org.apache.ibatis.annotations.Param;

/**
 * 查找某个对像基本资源.
 *
 * @param <T> 参数类型.
 * @param <R> 返回对像类型.
 */
public interface IGetBasicMapper<T, R> {

    /**
     * 查找某个对像基本资源 .
     *
     * @param id 资源标识
     * @return 当对像不存在时，返回 {@code null}
     */
    R getBasic(@Param("id") T id);
}
