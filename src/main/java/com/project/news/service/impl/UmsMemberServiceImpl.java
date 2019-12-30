package com.project.news.service.impl;

import com.project.news.beans.UmsMember;
import com.project.news.dao.UmsMemberMapper;
import com.project.news.service.UmsMemberService;
import com.project.news.vo.AdminPo;
import com.project.news.vo.Icon;
import com.project.news.vo.Password;
import com.project.news.vo.UserAdmin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Resource
    UmsMemberMapper umsMemberMapper;

    public UmsMember queryAdminByName(AdminPo adminPo) {

        return umsMemberMapper.selectByName(adminPo);
    }

    public UmsMember queryUserByName(String username) {

        return umsMemberMapper.selectUserByName(username);

    }

    public void modifyUserInfo(UserAdmin userAdmin) {
        System.out.println("22222");
        umsMemberMapper.updateUserInfoByName(userAdmin);
    }

    public void modifyPassowrd(Password password) {
        System.out.println(password.getOldPassword()+" "+password.getNewPassword()+" "+
                           password.getUsername());
        System.out.println(umsMemberMapper.selectPasswordByName(password.getUsername()));
        if(password.getOldPassword().equals(umsMemberMapper.selectPasswordByName(password.getUsername()))){
            umsMemberMapper.updatePasswordByName(password);
        }
    }

    @Override
    public void uploadIconCode(Icon icon) {

        umsMemberMapper.updateIconCodeByUsername(icon);
    }


}
