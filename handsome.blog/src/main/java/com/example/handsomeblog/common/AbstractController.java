package com.example.handsomeblog.common;


import cn.hutool.core.bean.BeanUtil;
import com.example.handsomeblog.common.inner.ICommonService;
import com.example.handsomeblog.common.page.QueryPage;
import com.github.pagehelper.PageSerializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 公共controller,提供一些controller相关的基础功能方法.
 */
public abstract class AbstractController {

    private ICommonService commonService;

    protected AbstractController(final ICommonService commonService) {
        this.commonService = commonService;
    }

    /**
     * List 对像属性 copy.
     *
     * <pre>
     *     如果源（src）为 null , 此方法返回空 list
     * </pre>
     *
     * @param src     源对像list
     * @param classes 目标对像类型
     * @param <T>     目标对像类型
     * @return 返回copy后的新对像
     */
    protected static <T> List<T> copy(final List<?> src, final Class<T> classes) {
        return Optional.ofNullable(src)
                .orElseGet(ArrayList::new)
                .stream()
                .map(obj -> BeanUtil.toBean(obj, classes))
                .collect(Collectors.toList());

    }

    /**
     * 对像属性copy.
     *
     * @param src     原始对像
     * @param classes 目标对像
     * @param <T>     目标对像类型
     * @return 当 @{code src}为null时，返回null
     */
    protected static <T> T copy(final Object src, final Class<T> classes) {
        return Optional.ofNullable(src).map(obj -> BeanUtil.toBean(obj, classes)).orElse(null);

    }

    /**
     * 对像属性copy.
     *
     * @param src     原始对像
     * @param classes 目标对像
     * @param <T>     目标对像类型
     * @return 当 @{code src}为null时，返回null
     */
    protected static <T> QueryPage<T> copy(final Class<T> classes, final QueryPage<?> src) {
        return Optional.ofNullable(src).map(obj -> {
            final QueryPage<T> pageInfo = copy(src, QueryPage.class);
            pageInfo.setData(Optional.ofNullable(obj.getData()).map(data -> copy(src.getData(), classes)).orElse(null));
            return pageInfo;
        }).orElse(null);
    }

    /**
     * 分页查询通用方法.
     *
     * @param <D>       DO
     * @param <R>       VO
     * @param <Q>       查询 VO
     * @param queryPage 分页参数
     * @param doClass   DO
     * @param voClass   VO
     * @return 返回 ReturnT
     */
    public <D, R, Q> ResponseResult getPage(final QueryPage<Q> queryPage, final Class<D> doClass, final Class<R> voClass) {
        final QueryPage<D> query = copy(doClass, queryPage);
        final PageSerializable page = this.commonService.page(query);
        page.setList(copy(page.getList(), voClass));
        return new ResponseResult(true, page);
    }

    /**
     * 增加数据.
     *
     * @param <D>     DO
     * @param <R>     VO
     * @param object  前段传入的对像
     * @param doClass DO
     * @return 返回 ReturnT
     */
    public <D, R> ResponseResult add(final Object object, final Class<D> doClass) {
        final D objectDo = copy(object, doClass);
        this.commonService.add(objectDo);
        return new ResponseResult();
    }

    /**
     * 根据唯一标识查询数据详情.
     *
     * @param <D>     DO
     * @param <R>     VO
     * @param id      唯一标识
     * @param doClass DO
     * @param voClass VO
     * @return 返回 ReturnT
     */
    public <D, R> ResponseResult find(final String id, final Class<D> doClass, final Class<R> voClass) {
        final Object result = this.commonService.find(id);
        return new ResponseResult(true, copy(result, voClass));
    }

    /**
     * 更新数据.
     *
     * @param <D>     DO
     * @param object  前端更新的对像
     * @param doClass DO
     * @return 返回 ReturnT
     */
    public <D, R> ResponseResult update(final Object object, final Class<D> doClass) {
        final D objectDo = copy(object, doClass);
        this.commonService.modify(objectDo);
        return new ResponseResult();
    }

}
