package com.funtl.hello.spring.transaction.service.impl;

import com.funtl.hello.spring.transaction.dao.TbContentCategoryDao;
import com.funtl.hello.spring.transaction.dao.TbContentDao;
import com.funtl.hello.spring.transaction.domain.TbContent;
import com.funtl.hello.spring.transaction.domain.TbContentCategory;
import com.funtl.hello.spring.transaction.service.TbContentCategoryService;
import com.funtl.hello.spring.transaction.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Autowired
    private TbContentService tbContentService;


    @Override
    public void save(TbContentCategory tbContentCategory, TbContent tbContent) {
        tbContentCategoryDao.insert(tbContentCategory);

//        if (true){
//            throw new RuntimeException();
//        }
        tbContentService.save(tbContent);

    }
}
