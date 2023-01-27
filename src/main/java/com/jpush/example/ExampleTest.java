package com.jpush.example;

import cn.jiguang.common.DeviceType;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.notification.Notification;

public class ExampleTest {
    public static void main(String[] args) {
        Platform platform = PushExample.platform(DeviceType.Android);
        Message message = null; //PushExample.Message("Message Title", "ContentType", "Content");
        Notification notification = PushExample.Notification("alert");
        PushExample.addPush(platform, message, notification);
    }
}
