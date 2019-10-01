package com.jungle.controller;

import com.jungle.aspect.HttpAspect;
import com.jungle.domain.Result;
import com.jungle.repository.BoyRepository;
import com.jungle.service.BoyService;
import com.jungle.domain.Boy;
import com.jungle.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jungle on 2019/2/22.
 */
@RestController
public class BoyController {
    private final static Logger logger = LoggerFactory.getLogger(BoyController.class);
    @Autowired
    private BoyRepository boyRepository;

    @Autowired
    private BoyService boyService;
    /**
     * 查询所有男生列表
     * @return
     */

    @GetMapping(value = "/boys")
    public List<Boy> boyList(){
        logger.info("boyList");
        return boyRepository.findAll();
    }

    /**
     * 添加一个男生
     * @return
     */
    @PostMapping(value = "/boys")
    public Result<Boy> boyAdd(@Valid Boy boy, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //return null;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
       boy.setCupSize(boy.getCupSize());
       boy.setAge(boy.getAge());
       return ResultUtil.success(boyRepository.save(boy));
    }
    //查询一个男生
    @GetMapping(value ="/boys/{id}")
    public Boy boyFindOne(@PathVariable("id") Integer id){
        return boyRepository.findById(id).get();
    }
    //更新
    @PutMapping(value = "/boys/{id}")
    public Boy boyUpdate(@PathVariable("id") Integer id,
                          @RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Boy boy =new Boy();
        boy.setId(id);
        boy.setCupSize(cupSize);
        boy.setAge(age);
         return boyRepository.save(boy);
    }
    //删除
    @DeleteMapping(value = "/boys/{id}")
    public void boyDelete(@PathVariable("id") Integer id){
        boyRepository.deleteById(id);
    }
    //通过年龄查询男生列表
    @GetMapping(value = "/boys/age/{age}")
    public  List<Boy> boyListByAge(@PathVariable("age") Integer age){
        return boyRepository.findByAge(age);
    }

    @PostMapping(value = "/boys/two")
    public void boyTwo(){
        boyService.insertTwo();
    }
    @GetMapping(value = "/boys/getAge/{id}")

    public void getAge(@PathVariable("id") Integer id) throws Exception{
          boyService.getAge(id);
    }
}

