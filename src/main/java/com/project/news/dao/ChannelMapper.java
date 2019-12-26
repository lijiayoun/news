package com.project.news.dao;

import com.project.news.beans.Channel;
import com.project.news.beans.ChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {
    long countByExample(ChannelExample example);

    int deleteByExample(ChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(String channelName);

    int insertSelective(Channel record);

    List<Channel> selectByExample(ChannelExample example);

    Channel selectByPrimaryKey(Integer id);

    List<Channel> selectAll();

    int selectChannelIdByName(String channelName);

    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByExample(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}