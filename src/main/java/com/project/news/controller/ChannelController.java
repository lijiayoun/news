package com.project.news.controller;

import com.project.news.beans.Channel;
import com.project.news.service.ChannelService;
import com.project.news.util.JsonResponse;
import com.project.news.util.Token;
import com.project.news.vo.ChannelName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChannelController {

    public static Map<Token, Channel> map = new HashMap<Token, Channel>();

    @Resource
    ChannelService channelService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("/channel"/*,method = RequestMethod.GET*/)
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

    @CrossOrigin
    @ResponseBody  /*将响应的数据转化为json类型*/
    @PutMapping("/channel")
    public JsonResponse<Channel> modifyChannelNameById(@RequestBody Channel channel){
        channelService.modifyChannelNameById(channel);
        JsonResponse<Channel> jsonData=new JsonResponse<Channel>();
        jsonData.setMessage("成功");
        jsonData.setData(channel);
        return jsonData;
    }

    @CrossOrigin
    /*@PathVariable("id") int id*/
    @ResponseBody  /*将响应的数据转化为json类型*/
    @DeleteMapping("/channel/{id}")
    public JsonResponse deleteChannelById(@PathVariable("id") int id){
        channelService.deleteChannelById(id);
        JsonResponse jsonData= new JsonResponse();
        jsonData.setMessage("成功");
        jsonData.setData(null);
        return jsonData;
    }

    @CrossOrigin
    @ResponseBody  /*将响应的数据转化为json类型*/
    @PostMapping("/channel")
    public JsonResponse<Channel> deleteChannelById(@RequestBody ChannelName channelName){
        System.out.println("111111");
        channelService.addChannel(channelName.getChannelname());
        System.out.println("222222");
        int id=channelService.queryChannelIdByName(channelName.getChannelname());
        System.out.println("333333");
        JsonResponse<Channel> jsonData=new JsonResponse<Channel>();
        jsonData.setMessage("成功");
        Channel channel=new Channel();
        channel.setChannelname(channelName.getChannelname());
        channel.setId(id);
        jsonData.setData(channel);
        return jsonData;
    }
}