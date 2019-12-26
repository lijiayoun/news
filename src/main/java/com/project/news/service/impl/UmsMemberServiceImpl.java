package com.project.news.service.impl;

import com.project.news.beans.UmsMember;
import com.project.news.dao.UmsMemberMapper;
import com.project.news.service.UmsMemberService;
import com.project.news.vo.AdminPo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Resource
    UmsMemberMapper umsMemberMapper;

    public UmsMember queryAdminByName(AdminPo adminPo) {
        System.out.println("2222222");

        return umsMemberMapper.selectByName(adminPo);
    }

}
