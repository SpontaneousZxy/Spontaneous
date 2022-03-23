package com.example.handsomeblog.common.inner;

import com.example.handsomeblog.common.page.QueryPage;
import com.github.pagehelper.PageSerializable;



/**
 * 分页查询服务.
 *
 * @param <T> 数据类型
 */
public interface IPageService<T, R> {

    /**
     * 查询分页数据.
     *
     * @param queryPage 分页查询参数
     * @return 返回分页数据.
     */
    PageSerializable<R> page(QueryPage<T> queryPage);
}
