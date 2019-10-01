package com.funtl.hello.spring.transaction.dao;

import com.funtl.hello.spring.transaction.domain.TbContent;
import org.springframework.stereotype.Repository;

@Repository
public interface TbContentDao {
    public void insert(TbContent tbContent);
}
