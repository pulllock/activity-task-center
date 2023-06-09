package me.cxis.activity.core.dao.mapper;

import me.cxis.activity.core.dao.model.ActivityEventDO;

public interface ActivityEventMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ActivityEventDO row);

    int insertSelective(ActivityEventDO row);

    ActivityEventDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActivityEventDO row);

    int updateByPrimaryKey(ActivityEventDO row);

    ActivityEventDO selectByCode(String code);
}