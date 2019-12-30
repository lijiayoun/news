package com.project.news.controller;

import com.project.news.beans.Content;
import com.project.news.service.ContentService;
import com.project.news.util.ArticleDetails;
import com.project.news.util.JsonResponse;
import com.project.news.vo.ModifiedArticle;
import com.project.news.vo.UploadArticle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class ContentController {

    @Resource
    ContentService contentService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("/content")
    public JsonResponse<List<Content>> showArticleList(@RequestParam int offset /*页码*/,@RequestParam int limit /*每页数据条数*/){
        System.out.println("offset:"+offset+" "+"limit:"+limit);
        int start;
        if(offset==0) {
            start =0 ;
        }
        else {
            start=(offset-1)*limit;
        }

        System.out.println("start:"+start+" "+"limit:"+limit);
        List<Content> list=contentService.showArticleList(start,limit);
        JsonResponse<List<Content>> jsonData=new JsonResponse<List<Content>>();
        jsonData.setMessage("成功");
        jsonData.setData(list);

        return jsonData;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/content/{id}")
    public JsonResponse<ArticleDetails> showArticleDetails(@PathVariable("id") int id){
        ArticleDetails articleDetails=contentService.showArticleDetails(id);

        JsonResponse<ArticleDetails> jsonData=new JsonResponse<ArticleDetails>();
        jsonData.setMessage("成功");

        jsonData.setData(articleDetails);
        return jsonData;
    }
    @CrossOrigin
    @ResponseBody
    @PutMapping("/content")
    public JsonResponse<ArticleDetails> modifyArticle(@RequestBody ModifiedArticle modifiedArticle){

        System.out.println(modifiedArticle.getTitle());

        JsonResponse<ArticleDetails> jsonData=new JsonResponse<ArticleDetails>();
        jsonData.setMessage("成功");
        jsonData.setData(null);
        return jsonData;
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("/article/create")
    public JsonResponse<ArticleDetails>  addArticle(@RequestBody UploadArticle uploadArticle){
        System.out.println("1111111");
        System.out.println(uploadArticle.getTitle()+" "+uploadArticle.getUrl()+" "+uploadArticle.getCreateDate()+" "+uploadArticle.getCount()+" "+uploadArticle.getCid());
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        uploadArticle.setUrl("http://www."+sb+".com");
        Date date=new Date();
        uploadArticle.setCreateDate(date);
        uploadArticle.setCid(7);
        ArticleDetails articleDetails=contentService.addArticle(uploadArticle);

        JsonResponse<ArticleDetails> jsonData=new JsonResponse<ArticleDetails>();
        jsonData.setMessage("成功");
        jsonData.setData(articleDetails);
        return jsonData;
    }


}