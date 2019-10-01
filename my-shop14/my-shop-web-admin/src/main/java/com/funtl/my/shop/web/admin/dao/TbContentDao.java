package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbContentDao {
    /**
     * 查询全部信息
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 新增
     * @param tbContent
     */
    void insert(TbContent tbContent);

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
     * @param params 需要两个参数，start/记录数开始的位置;length /每页的记录数
     * @return
     */
    List<TbContent> page(Map<String,Object> params);

    /**
     * 查询总笔数
     * @return
     */
    int count(TbContent tbContent);
}
