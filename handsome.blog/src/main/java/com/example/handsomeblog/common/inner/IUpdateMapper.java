package com.example.handsomeblog.common.inner;

/**
 * 数据更新统一服务.
 *
 * @param <T> 对象类型
 */
public interface IUpdateMapper<T> {

    /**
     * 更新数据接口 .
     *
     * @param obj 需要更新的对像
     * @return {@code >0}真实更新的数据个数
     */
    int update(T obj);
}
