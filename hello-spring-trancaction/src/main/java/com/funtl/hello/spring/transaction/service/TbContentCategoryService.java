package com.funtl.hello.spring.transaction.service;

import com.funtl.hello.spring.transaction.domain.TbContent;
import com.funtl.hello.spring.transaction.domain.TbContentCategory;

public interface TbContentCategoryService {
    public void save(TbContentCategory tbContentCategory, TbContent tbContent);
}
