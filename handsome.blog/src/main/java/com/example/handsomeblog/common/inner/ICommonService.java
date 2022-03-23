package com.example.handsomeblog.common.inner;


import com.example.handsomeblog.common.page.QueryPage;
import com.github.pagehelper.PageSerializable;


/**
 * 增删除改查.
 */
public interface ICommonService<D, R>
        extends IFindService<String, D>, IPageService<D, R>, IModifyService<D, Integer>, IRemoveService<String, Void>, IAddService<D, D> {

    @Override
    default D add(D obj) {
        return null;
    }

    @Override
    default D find(String id) {
        return null;
    }

    @Override
    default Integer modify(D obj) {
        return null;
    }

    @Override
    default PageSerializable<R> page(QueryPage<D> queryPage) {
        return null;
    }

    @Override
    default Void remove(String id) {
        return null;
    }
}
