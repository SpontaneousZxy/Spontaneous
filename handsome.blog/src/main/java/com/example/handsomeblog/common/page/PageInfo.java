package com.example.handsomeblog.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 本类应用于查询中分页参数包装
 * <br/>
 * 使用方法：
 * <br/>
 * 1.继承本类
 * <br/>
 * class QueryBean extends PageInfo{
 * <p>
 * Page page;
 * <p>
 * }
 * <br/>
 * <br/>
 * <br/>
 * 3.可以在查询bean里面获得start和end进行分页查询.
 *
 * @author cxm
 */
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 2599893924598183320L;

    private static final Integer DEFAULT_PAGE = 1;

    private static final Integer DEFAULT_SIZE = 10;


    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页行数
     */
    private Integer size;

    /**
     * 总记录数
     */
    private Integer total;

    /**
     * 排序字段
     */
    private String order;

    /**
     * true:降序，false：升序
     */
    private Boolean isDesc;

    /**
     * 搜索字段
     */
    private String search;


    private List<T> pageList;


    private T query;

    public PageInfo() {
    }

    public PageInfo(Integer page, Integer size, Integer total, String order, Boolean isDesc,
                    String search, List<T> pageList, T query) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.order = order;
        this.isDesc = isDesc;
        this.search = search;
        this.pageList = pageList;
        this.query = query;
    }

    public static <T> PageInfoBuilder<T> builder(Class<T> cls) {
        return new PageInfoBuilder<T>();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return null != this.size ? this.size : DEFAULT_SIZE;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean getDesc() {
        return isDesc;
    }

    public void setDesc(Boolean desc) {
        isDesc = desc;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getStart() {
        return ((null != this.page ? this.page : DEFAULT_PAGE) - 1) * (null != this.size ? this.size : DEFAULT_SIZE);
    }


    public static class PageInfoBuilder<T> {

        private Integer page;
        private Integer size;
        private Integer total;
        private String order;
        private Boolean isDesc;
        private String search;
        private List<T> pageList;
        private T query;

        PageInfoBuilder() {
        }

        public PageInfoBuilder<T> page(Integer page) {
            this.page = page;
            return this;
        }

        public PageInfoBuilder<T> size(Integer size) {
            this.size = size;
            return this;
        }

        public PageInfoBuilder<T> total(Integer total) {
            this.total = total;
            return this;
        }

        public PageInfoBuilder<T> order(String order) {
            this.order = order;
            return this;
        }

        public PageInfoBuilder<T> isDesc(Boolean isDesc) {
            this.isDesc = isDesc;
            return this;
        }

        public PageInfoBuilder<T> search(String search) {
            this.search = search;
            return this;
        }

        public PageInfoBuilder<T> pageList(List<T> pageList) {
            this.pageList = pageList;
            return this;
        }

        public PageInfoBuilder<T> query(T query) {
            this.query = query;
            return this;
        }

        public PageInfo<T> build() {
            return new PageInfo<T>(page, size, total, order, isDesc, search, pageList, query);
        }

    }
}
