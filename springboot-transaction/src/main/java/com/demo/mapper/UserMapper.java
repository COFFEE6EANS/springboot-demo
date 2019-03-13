package com.demo.mapper;

import com.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/13
 * @Description：
 */
@Repository
@Mapper
public interface UserMapper {

    @Update(value = "update user u set u.username=#{username} where u.id=#{id} ")
    void updateUsernameByid(User user);

    @Delete(value = "delete from user u where u.id=#{id} ")
    void delUserById(int id);

    @Select(value = "select * from user")
    List<User> findAll();

    @Select(value = "select * from user where id = #{id}")
    User findById(Integer id);

    @Insert("insert into user values(#{id},#{username})" )
    void save(User user);
}
