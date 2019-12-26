package com.project.news.service;

import com.project.news.beans.Channel;
import com.project.news.vo.ChannelName;

import java.util.List;

public interface ChannelService {


    public List<Channel> queryChannelById();

    public int modifyChannelNameById(Channel channel);

    public void deleteChannelById(int id);

    public void addChannel(String channelName);

    public int queryChannelIdByName(String channelName);
}
