package com.funtl.hello.spring.transaction.service.test;


import com.funtl.hello.spring.transaction.domain.TbContent;
import com.funtl.hello.spring.transaction.domain.TbContentCategory;
import com.funtl.hello.spring.transaction.service.TbContentCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
@Transactional
@Rollback

public class Mytest {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;


    @Test
    public void testTransaction(){
        TbContentCategory tbContentCategory=new TbContentCategory();
        tbContentCategory.setId(1L);
        tbContentCategory.setName("测试分类");

        TbContent tbContent=new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        tbContent.setContent("测试内容");

        tbContentCategoryService.save(tbContentCategory,tbContent);
    }
}
