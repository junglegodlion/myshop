package com.funtl.my.shop.web.api.dao;

import com.funtl.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 根据类别ID查询内容列表
 */
@Repository
public interface TbContentDao {

    List<TbContent> selectByCategoryId(TbContent tbContent);
}
