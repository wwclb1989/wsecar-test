package com.wsecar.systemmanager.autotest.channel;


import com.wsecar.systemmanager.argspackage.PageModel;
import com.wsecar.systemmanager.utils.ManagerHttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 渠道商相关测试
 */
public class ChannelTest {

    String url = "https://sysmanager-test1.wsecar.com/systemManager/channel/manager/channelInfo/select";
    String op = "selectChannelPage";
    Map<String, Object> map = new HashMap<String, Object>();


    /**
     * 线上渠道商列表
     * 不传任何参数
     */
    @Test
    public void testOnlineChannelPage() {
        PageModel pageModel = new PageModel();      // 列表是要分页的
        pageModel.setCurrentPage(1);    // 当前页
        pageModel.setPageSize(15);      // 每页条目数

        // 查询参数
        map.put("createModule", 1);
        pageModel.setBody(map);


//        Map<String, Object> result =new HashMap<String, Object>();
//        Map<String, Object> reqmapChannel =new HashMap<String, Object>();
        // 发送HTTP请求，得到列表
        List<Map<String, Object>> body = ManagerHttpUtil.doPost(url, op, pageModel);

        body.forEach(System.out::println);

    }

    /**
     * 线上渠道商列表
     * 查询渠道ID为1020473，状态为失效数据
     */
    @Test
    public void testonlineChannelPage1() {
        PageModel pageModel = new PageModel();      // 列表是要分页的
        pageModel.setCurrentPage(1);    // 当前页
        pageModel.setPageSize(15);      // 每页条目数

        map.put("createModule", "1");
        map.put("status", "2");
        map.put("channelId","1020473");
        pageModel.setBody(map);

        // 发送HTTP请求，得到列表
        List<Map<String, Object>> body = ManagerHttpUtil.doPost(url, op, pageModel);

        body.forEach(System.out::println);



    }


    @Test
    public void testChannelInfoDetail() {
        String url = "https://sysmanager-test1.wsecar.com/systemManager/channel/manager/channelInfo/select";
        String op = "selectChannelDetails";

        Map<String, Object> map = new HashMap<>();
        map.put("channelId", "1020479");

        Map<String, Object> data = ManagerHttpUtil.doPost(url, op, map);
        System.out.println(data);
    }

}
