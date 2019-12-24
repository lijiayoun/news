package com.project.news.dao;

import com.project.news.beans.Details;
import com.project.news.beans.DetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailsMapper {
    long countByExample(DetailsExample example);

    int deleteByExample(DetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Details record);

    int insertSelective(Details record);

    List<Details> selectByExample(DetailsExample example);

    Details selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Details record, @Param("example") DetailsExample example);

    int updateByExample(@Param("record") Details record, @Param("example") DetailsExample example);

    int updateByPrimaryKeySelective(Details record);

    int updateByPrimaryKey(Details record);
}