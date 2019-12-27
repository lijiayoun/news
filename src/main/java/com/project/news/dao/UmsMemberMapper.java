package com.project.news.dao;

import com.project.news.beans.UmsMember;
import com.project.news.beans.UmsMemberExample;
import java.util.List;

import com.project.news.vo.AdminPo;
import com.project.news.vo.Password;
import com.project.news.vo.UserAdmin;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberMapper {
    long countByExample(UmsMemberExample example);

    int deleteByExample(UmsMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    List<UmsMember> selectByExample(UmsMemberExample example);

    UmsMember selectByPrimaryKey(int id);

    UmsMember selectByName(AdminPo adminPo);

    UmsMember selectUserByName(String username);

    String selectPasswordByName(String username);

    int updateByExampleSelective(@Param("record") UmsMember record, @Param("example") UmsMemberExample example);

    int updateByExample(@Param("record") UmsMember record, @Param("example") UmsMemberExample example);

    int updateByPrimaryKeySelective(UmsMember record);

    void updateUserInfoByName(UserAdmin userAdmin);

    int updateByPrimaryKey(UmsMember record);

    void updatePasswordByName(Password password);


}