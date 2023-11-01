package com.saas.mongo.rocketmq;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.pub.core.common.TimingLog;
import com.saas.mongo.congfig.MqConstants;
import com.saas.mongo.service.OperationLogServiceImp;
import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.spring.annotation.ConsumeMode;
//import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Component
public class KafkaListener {

    @Autowired
    private OperationLogServiceImp operationLogServiceImp;

    //创建跟踪任务mq信息监听
    //监听一个或者多个Topic
    @org.springframework.kafka.annotation.KafkaListener(topics  = "mongologTopic")
    public void handler(String message){
        String[] msgArr = message.split("AAAAAAAA");
        if(msgArr.length==2){
            String msg = msgArr[1];
            List<JSONObject> list = JSONObject.parseObject(msg, List.class);
            log.info("收到消息："+list.size());
            operationLogServiceImp.saveLog(list);
        }
    }
}
