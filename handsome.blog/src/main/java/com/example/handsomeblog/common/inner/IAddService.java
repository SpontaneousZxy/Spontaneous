package com.example.handsomeblog.common.inner;

/**
 * 新增对像服务.
 *
 * <pre>
 *
 *     所有实现类的方法上应该保证使用注解@Validated(GroupAdd.class)，
 *     cglib使用的是实现类代理，无法取到接口方法体上的注解
 * </pre>
 *
 * @param <T> 输入参数的类型
 * @param <R> 返回参数的类型
 */
public interface IAddService<T, R> {

    /**
     * 新增数据到数据库中.
     *
     * @param obj 新增对像数据
     * @return 返回新增后的数据
     */
    R add(T obj);

}
