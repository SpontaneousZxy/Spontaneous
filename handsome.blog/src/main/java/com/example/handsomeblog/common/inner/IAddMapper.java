package com.example.handsomeblog.common.inner;

/**
 * 新增到数据库.
 *
 * @param <R> 对像类型.
 */
public interface IAddMapper<R> {

    /**
     * 查找某个对像资源 .
     *
     * @param object 需要增加的资源
     * @return 成功增加数据个数
     */
    int add(R object);
}
