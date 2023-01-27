package com.jpush.example;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.DeviceType;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class PushExample {
    private static String AppKey = "dbdc707ec1eaee42c8b6ea48";
    private static String MasterSecret = "c6eeed701a1e3ea0135feda2";
    private static JPushClient jPushClient = new JPushClient(MasterSecret, AppKey, null, ClientConfig.getInstance());

    public static void addPush(Platform platform, Message message, Notification notification){
        PushPayload payload = new PushPayload.Builder()
                .setPlatform(platform)
                .setAudience(Audience.newBuilder().setAll(true).build())
                .setMessage(message)
                .setNotification(notification)
                .build();
        try {
            jPushClient.sendPush(payload);
            System.out.println("发送成功");
        } catch (APIConnectionException e) {
            e.printStackTrace();
            System.out.println("连接异常");
        } catch (APIRequestException e) {
            e.printStackTrace();
            System.out.println("请求异常");
        }
    }

    public static Audience audience(Boolean setAll){
        return Audience.newBuilder().setAll(setAll).build();
    }

    public static Message Message(String title, String contentType, String content){
        Message message = Message.newBuilder()
                .setTitle(title)
                .setContentType(contentType)
                .setMsgContent(content)
                .build();
        return message;
    }

    public static Notification Notification(Object alert){
        Notification notification = Notification.newBuilder()
                .setAlert(alert)
                .build();
        return notification;
    }

    public static Platform platform(DeviceType deviceType){
        return Platform.newBuilder().addDeviceType(deviceType).build();
    }
}
