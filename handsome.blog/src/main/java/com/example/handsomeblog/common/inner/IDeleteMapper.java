package com.example.handsomeblog.common.inner;

import org.apache.ibatis.annotations.Param;

/**
 * 删除数据.
 *
 * @param <T> 对像类型.
 */
public interface IDeleteMapper<T> {

    /**
     * 删除数据库中数据.
     *
     * @param id 需要删除对像的唯一标识
     * @return 返回删除的数据个数。当结果 > 0 时，说明数据已删除
     */
    int delete(@Param("id") T id);
}
