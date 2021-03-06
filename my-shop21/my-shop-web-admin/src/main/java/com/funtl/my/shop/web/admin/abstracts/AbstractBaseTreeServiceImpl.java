package com.funtl.my.shop.web.admin.abstracts;

import com.funtl.my.shop.commons.persistence.BaseEntity;
import com.funtl.my.shop.commons.persistence.BaseTreeDao;
import com.funtl.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {
    @Autowired
    protected D dao;

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 删除用户信息
     *
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        dao.delete(id);
    }

    /**
     * 根据 ID 获取信息
     *
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    /**
     * 更新信息
     *
     * @param entity
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T entity) {
        dao.update(entity);
    }



    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */

    /**
     * 根据父级节点ID查询所有子节点
     * @param pid
     * @return
     */
    @Override
    public List<T> selectByPid(Long pid){
        return dao.selectByPid(pid);
    };

}
