package com.project.news.service.impl;

import com.project.news.beans.Channel;
import com.project.news.dao.ChannelMapper;
import com.project.news.service.ChannelService;
import com.project.news.vo.ChannelName;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Resource
    ChannelMapper channelMapper;

    public List<Channel> queryChannelById() {

        return channelMapper.selectAll();
    }


    public int modifyChannelNameById(Channel channel) {
       return channelMapper.updateByPrimaryKey(channel);
    }

    public void deleteChannelById(int id) {
        channelMapper.deleteByPrimaryKey(id);
    }

    public void addChannel(String channelName) {
        System.out.println("123456");
        channelMapper.insert(channelName);
    }

    public int queryChannelIdByName(String channelName) {

        return channelMapper.selectChannelIdByName(channelName);
    }


}
