package com.example.handsomeblog.common.page;

import java.io.Serializable;

/**
 * 排序对像.
 */
public class Sort implements Serializable {

    /**
     * asc（升序） .
     */

    public static final String ASC = "asc";

    /**
     * desc（降序） .
     */
    public static final String DESC = "desc";

    private static final long serialVersionUID = 1L;

    /**
     * 排序字段名 .
     */
    private String field;

    /**
     * 排序类型 .
     *
     * <pre>
     * 1. desc（降序）
     * 2. asc（升序）
     * 3. null（空对象，默认排序）
     * </pre>
     */
    private String type;

    /**
     * 需要排序的字段 .
     *
     * @return 需要排序的字段
     */
    public String getField() {
        return field;
    }

    /**
     * 获取 需要排序的字段 .
     *
     * @param field 需要排序的字段
     */
    public void setField(final String field) {
        this.field = field;
    }

    /**
     * 获取排序类型 .
     *
     * <pre>
     * 1. desc（降序）
     * 2. asc（升序）
     * 3. null（空对象，默认排序）
     * </pre>
     *
     * @return 获取排序类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置排序类型 .
     *
     * <pre>
     * 1. desc（降序）
     * 2. asc（升序）
     * 3. null（空对象，默认排序）
     * </pre>
     *
     * @param type 排序类型
     */
    public void setType(final String type) {
        this.type = type;
    }

}
