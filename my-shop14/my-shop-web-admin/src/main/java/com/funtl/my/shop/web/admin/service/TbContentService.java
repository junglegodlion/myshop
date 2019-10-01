package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.dto.PageInfo;
import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.domain.TbUser;

import java.util.List;
import java.util.Map;

public interface TbContentService {
    /**
     * 查询全部信息
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 新增
     * @param tbContent
     */
    BaseResult save(TbContent tbContent);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据ID查询信息
     * @param id
     * @return
     */
    TbContent getById(Long id);

    /**
     * 更新
     * @param tbContent
     */
    void update(TbContent tbContent);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @return
     */
    PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);

    /**
     * 查询总笔数
     * @return
     */
    int count(TbContent tbContent);
}
