package com.mapper;

import com.dto.TaskDO;
import com.vo.TaskVO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/5
 * @Description：
 */
@Mapper
@Repository
public interface TaskMapper {

        TaskDO get(Long id);

        List<TaskDO> list();

        List<TaskVO> listTaskVoByDesc(@Param("desc") String desc);

        int save(TaskDO task);

        int update(TaskDO task);

        int remove(Long id);

        int removeBatch(Long[] ids);


}
