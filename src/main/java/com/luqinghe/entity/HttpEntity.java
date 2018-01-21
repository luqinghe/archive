package com.luqinghe.entity;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * @author qinghe
 * @date 2018/01/07
 */
public class HttpEntity {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpEntity.class);

    /**
     * cookie
     */
    private static BasicCookieStore cookieStore = new BasicCookieStore();

    /**
     * client
     */
    private static CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

    /**
     * 模拟登录日志平台
     */
    public static void loginXinyuan() throws Exception {
        try {
            HttpGet httpget = new HttpGet("http://61.163.210.202:7001/yxpt/Index.jsp");
            CloseableHttpResponse indexPageResponse = httpclient.execute(httpget);
            try {
                org.apache.http.HttpEntity entity = indexPageResponse.getEntity();

                //String stringContent = new String(EntityUtils.toString(entity, "UTF-8"));
                //LOGGER.info("StringContent start\n========================{}\n==========================StringContent end",stringContent);

                LOGGER.info("Login form get: " + indexPageResponse.getStatusLine());
                EntityUtils.consume(entity);

                /*LOGGER.info("Initial set of cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    LOGGER.info("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        LOGGER.info("- " + cookies.get(i).toString());
                    }
                }*/
            } finally {
                indexPageResponse.close();
            }

            HttpUriRequest login = RequestBuilder.post()
                    .setUri(new URI("http://61.163.210.202:7001/yxpt/j_spring_security_check"))
                    .addParameter("j_username", "luqinghe")
                    .addParameter("j_password", "password")
                    .addParameter("j_checkcode", "0000")
                    .build();

            CloseableHttpResponse loginResponse = httpclient.execute(login);
            try {
                org.apache.http.HttpEntity entity = loginResponse.getEntity();

                //String stringContent = new String(EntityUtils.toString(entity, "UTF-8"));
                //LOGGER.info("StringContent start\n========================{}\n==========================StringContent end",stringContent);

                LOGGER.info("Login form get: " + loginResponse.getStatusLine());
                EntityUtils.consume(entity);

                /*LOGGER.info("Post logon cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    LOGGER.info("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        LOGGER.info("- " + cookies.get(i).toString());
                    }
                }*/
            } finally {
                loginResponse.close();
            }

            HttpGet httpgetMyLog = new HttpGet("http://61.163.210.202:7001/yxpt/eps/gzrz/bxrz/EditGzrz.html");
            CloseableHttpResponse myLogPageResponse = httpclient.execute(httpgetMyLog);
            try {
                org.apache.http.HttpEntity entity = myLogPageResponse.getEntity();

                String stringContent = new String(EntityUtils.toString(entity, "UTF-8"));
                LOGGER.info("StringContent start\n========================{}\n==========================StringContent end",stringContent);

                LOGGER.info("Login form get: " + myLogPageResponse.getStatusLine());
                EntityUtils.consume(entity);

            /*LOGGER.info("Initial set of cookies:");
            *//*List<Cookie> cookies = cookieStore.getCookies();
            if (cookies.isEmpty()) {
                LOGGER.info("None");
            } else {
                for (int i = 0; i < cookies.size(); i++) {
                    LOGGER.info("- " + cookies.get(i).toString());
                }
            }*/
            } finally {
                myLogPageResponse.close();
            }

        } finally {
            httpclient.close();
        }


    }
}
