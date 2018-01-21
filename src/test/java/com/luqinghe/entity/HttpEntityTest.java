package com.luqinghe.entity;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by qinghe on 2018/1/7.
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpEntityTest {
    @Test
    public void loginXinyuanTest() throws Exception {
        HttpEntity.loginXinyuan();
    }

}