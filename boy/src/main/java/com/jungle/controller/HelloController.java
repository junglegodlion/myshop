package com.jungle.controller;

import com.jungle.properties.BoyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jungle on 2019/2/21.
 */


@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private BoyProperties boyProperties;
//    @RequestMapping(value ="/say",method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value="id",required = false,defaultValue = "0") Integer id){
     return "id:"+id;
// return boyProperties.getCupSize();
    }
}
