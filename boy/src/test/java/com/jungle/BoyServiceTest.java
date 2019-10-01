package com.jungle;

import com.jungle.domain.Boy;
import com.jungle.service.BoyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jungle on 2019/2/23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoyServiceTest {
    @Autowired
    private BoyService boyService;

    @Test
    public void findOneTest(){
        Boy boy=boyService.findOne(13);
        Assert.assertEquals(new Integer(13),boy.getAge());
    }


}
