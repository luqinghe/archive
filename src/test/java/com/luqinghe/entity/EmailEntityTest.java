package com.luqinghe.entity;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by qinghe on 2017/12/27.
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailEntityTest {
    @Test
    public void sendSimpleEmailTest() throws Exception {
        EmailEntity.sendSimpleEmail();
    }

    @Test
    public void sendMultiPartEmailTest() throws Exception {
        EmailEntity.sendMultiPartEmail();
    }

}