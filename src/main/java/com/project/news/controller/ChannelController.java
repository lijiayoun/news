package com.project.news.controller;

import com.project.news.beans.Channel;
import com.project.news.service.ChannelService;
import com.project.news.util.ChannelInfo;
import com.project.news.util.JsonResponse;
import com.project.news.util.Token;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class ChannelController {

    public static Map<Token, Channel> map = new HashMap<Token, Channel>();

    @Resource
    ChannelService channelService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/channel"/*,method = RequestMethod.GET*/)
    public JsonResponse<List<Channel>> showChannelLabel() {
        List<Channel> list = channelService.queryChannelById();

        JsonResponse<List<Channel>> jsonData = new JsonResponse<List<Channel>>();
        jsonData.setMessage("获取频道列表成功！");

        if (list != null) {
            jsonData.setData(list);
            return jsonData;

        }

        return null;
    }
}