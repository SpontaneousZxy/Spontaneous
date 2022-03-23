package com.example.handsomeblog.common.inner;


import com.example.handsomeblog.common.page.QueryPage;

import java.util.List;

/**
 * 数据库分页查询.
 *
 * @param <T> 对像类型
 */
public interface IPageMapper<T> {

    /**
     * 分业查询数据库接口，供pageHelper使用 .
     *
     * @param queryPage 分页查询数据
     * @return 返回分业数据
     */
    List<T> page(QueryPage<T> queryPage);
}
