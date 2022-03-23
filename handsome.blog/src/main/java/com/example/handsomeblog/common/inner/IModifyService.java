package com.example.handsomeblog.common.inner;

/**
 * 数据修改.
 *
 * @param <T> 参数类型.
 * @param <R> 返回对像类型.
 */
public interface IModifyService<T, R> {

    /**
     * 修改数据 .
     *
     * @param obj 待修改的数据
     * @return 当对像不存在时，返回 {@code null}
     */
    R modify(T obj);
}
