package com.project.news.service;


import com.project.news.beans.UmsMember;
import com.project.news.vo.AdminPo;
import com.project.news.vo.Password;
import com.project.news.vo.UserAdmin;

public interface UmsMemberService  {

    public UmsMember queryAdminByName(AdminPo adminPo);


    public UmsMember queryUserByName(String username);

    public void modifyUserInfo(UserAdmin userAdmin);

    public void modifyPassowrd(Password password);
}
