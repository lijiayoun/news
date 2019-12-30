package com.project.news.service;

import com.project.news.beans.Content;
import com.project.news.util.ArticleDetails;
import com.project.news.vo.ModifiedArticle;
import com.project.news.vo.UploadArticle;

import java.util.List;

public interface ContentService {

    public List<Content> showArticleList(int start,int limit);

    public ArticleDetails showArticleDetails(int id);

    public ArticleDetails addArticle(UploadArticle uploadArticle);

    public ArticleDetails modifyArticle(ModifiedArticle modifiedArticle);

}
