package com.project.news.dao;

import com.project.news.beans.Content;
import com.project.news.beans.ContentExample;
import java.util.List;

import com.project.news.beans.Details;
import com.project.news.util.ArticleDetails;
import com.project.news.vo.UploadArticle;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
    long countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Content record);

    int insertSelective(Content record);

    void insertArticle(UploadArticle uploadArticle);

    void insertIntoDetailsText(Details details);

    List<Content> selectByExample(ContentExample example);

    Content selectByPrimaryKey(Integer id);

    List<Content> selectArticleList(int limit);

    ArticleDetails selectArticleDetails(int id);

    int selectContentIdByUrl(String url);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}