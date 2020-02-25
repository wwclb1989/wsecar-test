package com.wsecar.channelmanager.channelwx;

import com.wsecar.channelmanager.utils.ManagerHttpUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class channellogin {
    String url = "https://ccm-h5-test1.wsecar.com/channelManager/registerChannel";
    Map<String, Object> map = new HashMap<String, Object>();

    @Test
    public void registerChannel() {
        map.put("channelAccount", "13911112115");
        map.put("areaCode", "100105");
        map.put("channelName", "13911112115");
        map.put("channelType", "-1");
        map.put("idempotenceToken", "6a51116df2f44f188335f884aaed1446");
        map.put("phone", "13911112115");
        map.put("provinceCityName", "北京市");
        map.put("companyName", "0");
        map.put("channelId", "0");
        map.put("brancheId", "0");
        map.put("districtId", "0");
        map.put("recommenderId", "0");
        map.put("createModule", "8");

        Map<String, Object> data = ManagerHttpUtil.doPost(url, map);
        System.out.println(data);

    }
}