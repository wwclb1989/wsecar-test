package com.wsecar.channelmanager.utils;



import com.wsecar.common.exception.BusinessException;
import com.wsecar.common.utils.JsonUtil;
import com.wsecar.common.utils.WsecarHttpUtil;
import com.wsecar.systemmanager.resultpackage.ResultPacket;
import com.wsecar.systemmanager.resultpackage.ResultPageModel;

import java.util.List;
import java.util.Map;

public class ManagerHttpUtil {

    // 管理后台登录Token
    public static final String TOKEN = "MjAyMDAyMjQxNDQ2MTcwMDc6MjpAQiMzMiYqQUJhYjpkYzEtYWxpeXVuLWhuMS1hemItZmF0MS1hcHAwMTow";

    /**
     * 用于分页请求
     * @param url   请求url
     * @param op    请求接口op
     * @param pageModel     // 分页模型
     * @return
     */
    public static List<Map<String, Object>> doPost(String url, String op, PageModel pageModel) {

        // 请求消息体打包
        ManagerPacket packet = new ManagerPacket();
        packet.setToken(TOKEN);     // token是认证信息
        packet.setOp(op);
        packet.setData(JsonUtil.toJson(pageModel));
        System.out.println(JsonUtil.toJson(pageModel));

        String response = WsecarHttpUtil.post(url, JsonUtil.toJson(packet));
        ResultPacket result = JsonUtil.fromJson(response, ResultPacket.class);

        // 判断响应码，对于我们的业务来说，正常码值为1
        if (!result.getCode().equals(1)) {
            System.out.println("code:" + result.getCode() + ", msg:" + result.getMsg());
            throw new BusinessException(result.getCode(), result.getMsg());
        }

        String data = result.getData();
        ResultPageModel resultPageModel = JsonUtil.fromJson(data, ResultPageModel.class);

        return resultPageModel.getBody();
    }

    /**
     * 非分页请求
     * @param url
     * @param op
     * @param args
     * @return
     */
    public static Map<String, Object> doPost(String url, String op, Map<String, Object> args) {
        ManagerPacket packet = new ManagerPacket();
        packet.setToken(TOKEN);
        packet.setOp(op);
        packet.setData(JsonUtil.toJson(args));

        String response = WsecarHttpUtil.post(url, JsonUtil.toJson(packet));
        ResultPacket result = JsonUtil.fromJson(response, ResultPacket.class);

        // 判断响应码，对于我们的业务来说，正常码值为1
        if (!result.getCode().equals(1)) {
            System.out.println("code:" + result.getCode() + ", msg:" + result.getMsg());
            throw new BusinessException(result.getCode(), result.getMsg());
        }

        if (result.getData() == null) {
            return null;
        }

        return JsonUtil.fromJson(result.getData(), Map.class);
    }


    /**
     * 前端请求接口
     * @param url
     * @param args
     * @return
     */
    public static Map<String, Object> doPost(String url, Map<String, Object> args) {
        ManagerPacket packet = new ManagerPacket();
        packet.setData(JsonUtil.toJson(args));

        String response = WsecarHttpUtil.post(url, JsonUtil.toJson(packet));
        ResultPacket result = JsonUtil.fromJson(response, ResultPacket.class);

        // 判断响应码，对于我们的业务来说，正常码值为1
        if (!result.getCode().equals(1)) {
            System.out.println("code:" + result.getCode() + ", msg:" + result.getMsg());
            throw new BusinessException(result.getCode(), result.getMsg());
        }

        if (result.getData() == null) {
            return null;
        }

        return JsonUtil.fromJson(result.getData(), Map.class);
    }



    public static void main(String[] args) {

    }

}
