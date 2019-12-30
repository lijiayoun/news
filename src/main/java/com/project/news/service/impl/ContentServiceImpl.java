package com.project.news.service.impl;

import com.project.news.beans.Content;
import com.project.news.beans.Details;
import com.project.news.dao.ContentMapper;
import com.project.news.service.ContentService;
import com.project.news.util.ArticleDetails;
import com.project.news.vo.ModifiedArticle;
import com.project.news.vo.StartAndLimit;
import com.project.news.vo.UploadArticle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Resource
    ContentMapper contentMapper;

    public List<Content> showArticleList(int start,int limit) {

        StartAndLimit sal=new StartAndLimit();
        sal.setStart(start);sal.setLimit(limit);
        return contentMapper.selectArticleList(sal);
    }


    public ArticleDetails showArticleDetails(int id) {

        return contentMapper.selectArticleDetails(id);
    }

    public ArticleDetails addArticle(UploadArticle uploadArticle) {

        Details details=new Details();
        contentMapper.insertArticle(uploadArticle);


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

    public ArticleDetails modifyArticle(ModifiedArticle modifiedArticle) {
        System.out.println(modifiedArticle.getTitle());
        contentMapper.updateInfoByTitle(modifiedArticle);

        int id=contentMapper.selectIdByTitle(modifiedArticle.getTitle());
        System.out.println(id+" "+modifiedArticle.getTitle());
        return null;
    }
}
