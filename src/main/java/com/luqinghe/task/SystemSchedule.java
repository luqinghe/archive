package com.luqinghe.task;

import com.luqinghe.entity.EmailEntity;
import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

/**
 * Created by qinghe on 2017/12/27.
 * @author qinghe
 * @date 2017-12-28
 */
public class SystemSchedule {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemSchedule.class);

    @Scheduled(cron = "0 0 8 * * ? *")
    public void sendEmail() {

        try {
            // 随机休眠[0,500)秒
            Thread.sleep((long)new Random().nextInt(500)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Schedule ==> Email is sending.");
        try {
            EmailEntity.sendSimpleEmail();
        } catch (EmailException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
