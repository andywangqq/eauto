package com.eauto.mapper;

import java.util.List;
import java.util.Map;

/**
 * author name: Andy
 * create time: 2021-09-30 15:33:32
 */
public interface BaseMapper<T> {
    int save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] id);

    T queryObject(Object id);

    List<T> queryList(Map<String, Object> map);

    List<T> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}
