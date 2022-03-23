package com.example.handsomeblog.common.page;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 分页查询实体.
 *
 * @param <T> 参数类型
 */
public class QueryPage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 时间分割后长度 .
     */
    private static final int RANGEDATE_SPLIT_SIZE = 2;

    /**
     * 当前页 .
     */
    private int page;

    /**
     * 每页显示个数 .
     */
    private int limit;

    /**
     * 条件查询数据 .
     */
    private T data;

    /**
     * 查询关键字.
     */
    private String keyword;

    /**
     * 查询开始时间 .
     */
    private Date startDate;

    /**
     * 查询结束时间 .
     */
    private Date endDate;

    /**
     * 查询时间范围 .
     */
    private String rangeDate;

    /**
     * 排序字段 .
     */
    private List<Sort> sort;

    /**
     * 返回 当前页 .
     *
     * @return 当前页
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置 当前页 .
     *
     * @param page 当前页
     * @return 当前对像
     */
    public QueryPage<T> setPage(final int page) {
        this.page = page;
        return this;
    }

    /**
     * 返回 每页显示个数 .
     *
     * @return 每页显示个数
     */
    public int getLimit() {
        return limit;
    }

    /**
     * 设置 每页显示个数 .
     *
     * @param limit 每页显示个数
     * @return 当前对像
     */
    public QueryPage<T> setLimit(final int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * 返回 条件查询数据 .
     *
     * @return 条件查询数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置 条件查询数据 .
     *
     * @param data 条件查询数据
     * @return 当前对像
     */
    public QueryPage<T> setData(final T data) {
        this.data = data;
        return this;
    }

    /**
     * 返回 查询关键字 .
     *
     * @return 查询关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 设置 查询关键字 .
     *
     * @param keyword 查询关键字
     * @return 当前对像
     */
    public QueryPage<T> setKeyword(final String keyword) {
        this.keyword = keyword;
        return this;
    }

    /**
     * 返回查询开始时间 .
     *
     * @return 返回查询开始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置查询开始日期 .
     *
     * @param startDate 开始日期
     */
    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 返回查询结束日期 .
     *
     * @return 返回查询结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置查询结束日期 .
     *
     * @param endDate 结束日期
     */
    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 返回需要查询的时间范围 .
     *
     * @return 返回时间范围
     */
    public String getRangeDate() {
        return rangeDate;
    }

    /**
     * 设置时间范围 {@code 2017-11-12 - 2018-12-12} .
     *
     * @param rangeDate 格式 {@code 2017-11-12 - 2018-12-12}
     */
    public void setRangeDate(final String rangeDate) {
        // 2019-10-02 - 2019-11-20
        this.rangeDate = rangeDate;
        Optional.ofNullable(rangeDate).ifPresent(t -> {
            final String[] ranges = rangeDate.split(" - ");
            Optional.ofNullable(ranges).filter(s -> s.length == RANGEDATE_SPLIT_SIZE).ifPresent(s -> {
                this.startDate = DateUtil.parse(s[0]).toJdkDate();
                this.endDate = DateUtil.parse(s[1]).toJdkDate();
            });
        });
    }

    /**
     * 返回需要排序的字段 .
     *
     * @return 返回需要排序的字段
     */
    public List<Sort> getSort() {
        return CollectionUtil.removeNull(sort);
    }

    /**
     * 设置需要排序的字段 .
     *
     * @param sort 设置需要排序的字段
     */
    public void setSort(final List<Sort> sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" {page:");
        builder.append(page);
        builder.append(", limit:");
        builder.append(limit);
        builder.append(", data:");
        builder.append(data);
        builder.append(", keyword:");
        builder.append(keyword);
        builder.append(", startDate:");
        builder.append(startDate);
        builder.append(", endDate:");
        builder.append(endDate);
        builder.append(", rangeDate:");
        builder.append(rangeDate);
        builder.append(", sort:");
        builder.append(sort);
        builder.append("}");
        return builder.toString();
    }

}
