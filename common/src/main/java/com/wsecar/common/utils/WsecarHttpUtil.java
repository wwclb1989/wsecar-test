package com.wsecar.common.utils;

import com.wsecar.common.exception.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class WsecarHttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(WsecarHttpUtil.class);

    private static HttpConnectionManager httpConnManager;

    private static final Object lock = new Object();

    private static void createHttpConnectionManager(String certPassword, String certPath) {
        if (null == httpConnManager) {
            synchronized (lock) {
                if (null == httpConnManager) {
                    HttpConnectionManager conn = new HttpConnectionManager();
                    try {
                        conn.init(certPassword, certPath);
                    } catch (IOException e) {
                        logger.error("初始化Http连接管理器失败, ", e);
                        throw new HttpException();
                    }
                    httpConnManager = conn;
                }
            }
        }
    }

    /**
     * Get方式
     * @param url   调用的完整url
     * @param args  请求参数
     * @return      响应报文
     */
    public static String get(String url, Map<String, Object> args) {
        createHttpConnectionManager(null, null);

        try {
            HttpGet httpGet = new HttpGet(url);

            httpGet.addHeader("Content-Type", "application/json; charset=UTF-8");
            httpGet.addHeader("Accept", "application/json, text/plain, */*");

            // 拼接参数到url

            HttpResponse response = httpConnManager.getConnection().execute(httpGet);

            String result = EntityUtils.toString(response.getEntity(), "utf-8");

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK
                    && response.getStatusLine().getStatusCode() != HttpStatus.SC_ACCEPTED
                    && response.getStatusLine().getStatusCode() != HttpStatus.SC_NO_CONTENT) {
                throw new HttpException();
            }

            return result;
        } catch (Exception e) {
            logger.error("http请求失败, url:{}", url, e);
            throw new HttpException();
        }

    }

    /**
     * POST请求
     * @param url           请求url
     * @param body          请求体
     * @return
     */
    public static String post(String url, String body) {
        createHttpConnectionManager(null, null);

        try{
            HttpPost httpPost = new HttpPost(url); // 设置响应头信息
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("Accept", "application/json");

            httpPost.setEntity(new StringEntity(body, "UTF-8"));

            HttpResponse response = httpConnManager.getConnection().execute(httpPost);

            String result = EntityUtils.toString(response.getEntity(), "utf-8");

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK
                    && response.getStatusLine().getStatusCode() != HttpStatus.SC_ACCEPTED
                    && response.getStatusLine().getStatusCode() != HttpStatus.SC_NO_CONTENT) {
                throw new HttpException(response.getStatusLine().getStatusCode());
            }

            return result;
        } catch (Exception e) {
            logger.error("http请求失败, url:{}", url, e);
            throw new HttpException();
        }
    }

    public static void main(String[] args) {

    }
}
