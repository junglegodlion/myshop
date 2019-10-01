package com.jungle.service;

import com.jungle.enums.ResultEnum;
import com.jungle.exception.BoyException;
import com.jungle.repository.BoyRepository;
import com.jungle.domain.Boy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by jungle on 2019/2/22.
 */
@Service
public class BoyService {
    @Autowired
    private BoyRepository boyRepository;

    @Transactional //同时成功，或同时失败
    public void insertTwo() {
        Boy boyA = new Boy();
        boyA.setCupSize("A");
        boyA.setAge(18);
        boyRepository.save(boyA);

        Boy boyB = new Boy();
        boyB.setCupSize("BBBBB");
        boyB.setAge(19);
        boyRepository.save(boyB);
    }

    public void getAge(Integer id) throws Exception {
        Boy boy = boyRepository.findById(id).get();
        Integer age = boy.getAge();
        if (age < 10) {
            //返回“你还在上小学”。返回“100”
            throw new BoyException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16)

        {
            //返回“你可能上初中”.返回“101”
            throw new BoyException(ResultEnum.MIDDLE_SCHOOL);
        }else if(age >16) {
            //如果>16岁，加钱
            //。。。
            throw new BoyException(ResultEnum.HIGH_SCHOOL);
        }
    }

    /**
     * 通过Id查询一个男生的信息
     * @param id
     * @return
     */
    public Boy findOne(Integer id){
            return boyRepository.findById(id).get();
        }
}





