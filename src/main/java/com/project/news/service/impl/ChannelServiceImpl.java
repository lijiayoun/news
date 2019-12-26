package com.project.news.service.impl;

import com.project.news.beans.Channel;
import com.project.news.dao.ChannelMapper;
import com.project.news.service.ChannelService;
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
}
