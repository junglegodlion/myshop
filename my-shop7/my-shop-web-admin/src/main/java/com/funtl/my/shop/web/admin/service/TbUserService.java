package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {
    public List<TbUser> selectAll();

    void insert(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);
}
