package com.funtl.hello.spring.transaction.dao;

import com.funtl.hello.spring.transaction.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface TbContentCategoryDao {
    public void insert(TbContentCategory tbContentCategory);
}
