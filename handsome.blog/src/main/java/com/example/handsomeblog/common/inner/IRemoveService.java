package com.example.handsomeblog.common.inner;

/**
 * 根据条件删除数据.
 *
 * @param <T> 参数类型
 * @param <R> 返回数据类型
 */
public interface IRemoveService<T, R> {

    /**
     * 根据条件删除数据.
     *
     * @param id 待删除的数据
     * @return 一般情况下应该是返回 {@code int} 可定制返回数据
     */
    R remove(T id);
}
