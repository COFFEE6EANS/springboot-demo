package com.tkmybatis.base;

import tk.mybatis.mapper.common.*;

/**
 *  IdsMapper<T>
 *  ConditionMapper<T>
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}