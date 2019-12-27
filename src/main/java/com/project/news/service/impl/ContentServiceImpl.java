package com.project.news.service.impl;

import com.project.news.beans.Content;
import com.project.news.beans.Details;
import com.project.news.dao.ContentMapper;
import com.project.news.service.ContentService;
import com.project.news.util.ArticleDetails;
import com.project.news.vo.UploadArticle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Resource
    ContentMapper contentMapper;

    public List<Content> showArticleList(int limit) {

        return contentMapper.selectArticleList(limit);
    }


    public ArticleDetails showArticleDetails(int id) {

        return contentMapper.selectArticleDetails(id);
    }

    public ArticleDetails addArticle(UploadArticle uploadArticle) {
        System.out.println("22222");
        Details details=new Details();
        contentMapper.insertArticle(uploadArticle);
        System.out.println("33333");

        int contentId=contentMapper.selectContentIdByUrl(uploadArticle.getUrl());
        System.out.println(contentId);
        details.setContentId(contentId);
        details.setText(uploadArticle.getText());
        contentMapper.insertIntoDetailsText(details);

        ArticleDetails articleDetails=new ArticleDetails();
        articleDetails.setText(uploadArticle.getTitle());
        articleDetails.setUrl(uploadArticle.getUrl());
        articleDetails.setImg(uploadArticle.getImg());
        articleDetails.setCreateDate(uploadArticle.getCreateDate());
        articleDetails.setCount(uploadArticle.getCount());
        articleDetails.setCid(uploadArticle.getCid());
        articleDetails.setText(uploadArticle.getText());
        articleDetails.setContentId(contentId);

        return articleDetails;
    }
}
