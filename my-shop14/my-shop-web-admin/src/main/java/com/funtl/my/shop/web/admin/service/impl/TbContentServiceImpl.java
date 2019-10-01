package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.commons.dto.PageInfo;
import com.funtl.my.shop.domain.TbContent;
import com.funtl.my.shop.web.admin.dao.TbContentDao;
import com.funtl.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        BaseResult baseResult=checkTbContent(tbContent);


        //通过验证
        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            tbContent.setUpdated(new Date());

            //新增
            if(tbContent.getId()==null){
                //密码需要加密
                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
            }
            //编辑用户
            else{
                tbContentDao.update(tbContent);
            }
            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;

    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);

    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update(TbContent tbContent) {

        tbContentDao.update(tbContent);
    }

    @Override
    public void deleteMulti(String[] ids) {

        tbContentDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContent> page(int start, int length,int draw,TbContent tbContent) {
        int count = tbContentDao.count(tbContent);
        Map<String,Object> params=new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("tbContent",tbContent);
        PageInfo<TbContent> pageInfo =new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContentDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }

    /**
     * 用户信息的有效性验证
     * @param tbContent
     * @return
     */
    private BaseResult checkTbContent(TbContent tbContent){
        BaseResult baseResult=BaseResult.success();
        //非空验证
        if (tbContent.getCategoryId()==null){
            baseResult=BaseResult.fail("内容的所属分类不能为，请重新输入");
        }


        return baseResult;
    }
}
