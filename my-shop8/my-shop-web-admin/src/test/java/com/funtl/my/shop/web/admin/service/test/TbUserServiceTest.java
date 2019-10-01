package com.funtl.my.shop.web.admin.service.test;


import com.funtl.my.shop.domain.TbUser;
import com.funtl.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll(){
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers){
            System.out.println(tbUser.getUsername());
        }
    }
    @Test
    public void testInsert(){
        TbUser tbUser=new TbUser();
        tbUser.setUsername("jungle");
        tbUser.setPhone("15151838131");
        tbUser.setEmail("1037044430@qq.com");
        //密码加密
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456789".getBytes()));
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUserService.insert(tbUser);
    }
    @Test
    public void testDelete(){
        //L是Long类型
        tbUserService.delete(38L);
    }
    @Test
    public void testGetById(){
        TbUser tbUser = tbUserService.getById(36L);
        System.out.println(tbUser.getUsername());
    }
    @Test
    public void testUpdate(){
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("jungle");
        tbUserService.update(tbUser);
    }
    @Test
    public void testSelectByUsername() {
        List<TbUser> tbUsers = tbUserService.selectByUsername("uni");
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }
    @Test
    public void testMD5(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
