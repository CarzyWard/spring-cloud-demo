package com.zzwy.service;

import java.util.List;


/**
 * DAO通用接口
 *
 * @author zhongsy
 * @date 2019/2/28
 */
public interface BaseService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int deleteByEntity(T entity);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    public int selectCountByExampleMapper(Object example);

    public T selectOne(T entity);

    public List<T> select(T entity);

    public int selectCount(T entity);
}
