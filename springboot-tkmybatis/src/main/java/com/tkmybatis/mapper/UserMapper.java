package com.tkmybatis.mapper;

import com.tkmybatis.base.BaseMapper;
import com.tkmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/23
 * @Description：
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
