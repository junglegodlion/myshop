package com.funtl.hello.spring.transaction.service.impl;

import com.funtl.hello.spring.transaction.dao.TbContentDao;
import com.funtl.hello.spring.transaction.domain.TbContent;
import com.funtl.hello.spring.transaction.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;
    @Override
    public void save(TbContent tbContent) {
        tbContentDao.insert(tbContent);

    }
}
