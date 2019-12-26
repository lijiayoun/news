package com.project.news.service;


import com.project.news.beans.UmsMember;
import com.project.news.vo.AdminPo;

public interface UmsMemberService  {

    public UmsMember queryAdminByName(AdminPo adminPo);
}
