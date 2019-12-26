package com.project.news.test;

        import com.project.news.beans.UmsMember;
        import com.project.news.beans.UmsMemberExample;
        import com.project.news.dao.UmsMemberMapper;
        import org.junit.Test;

public class TestMapper {

    UmsMemberMapper umsMemberMapper;

    @Test
    public void test1(){
        umsMemberMapper.selectByPrimaryKey(1);

    }
}
