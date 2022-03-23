package com.example.handsomeblog.common.inner;

/**
 * 验证某个资源是否存在.
 *
 * @param <T> 参数类型.
 */
public interface ICountMapper<T> {

    /**
     * 验证某个资源是否存在 .
     *
     * <pre>
     *     只查询前两条数据，提高查询效率
     *     当 count = 0 ，未找到数据
     *     当 count = 1 , 资源存在
     *     当 count = 2 , 数据库存在重复的资源
     * </pre>
     *
     * @param condition 资源标识
     * @return 返回符合条件的计数
     */
    Integer count(T condition);
}
