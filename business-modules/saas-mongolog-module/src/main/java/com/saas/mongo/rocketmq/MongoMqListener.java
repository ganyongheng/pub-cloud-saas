/*
package com.saas.mongo.rocketmq;

import com.alibaba.fastjson2.JSONObject;
import com.pub.core.common.TimingLog;
import com.saas.mongo.congfig.MqConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = MqConstants.MQ_TOPIC_TRACKING_GROUP, topic = MqConstants.MQ_TOPIC_SAAS_TRACKING,consumeMode = ConsumeMode.ORDERLY)
public class MongoMqListener implements RocketMQListener<MessageExt> {

    //创建跟踪任务mq信息监听
    @TimingLog
    @Override
    public void onMessage(MessageExt messageExt) {
        String msgStr = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        log.info("接收到mq消息队列"+messageExt.getMsgId()+"消息内容："+msgStr);
        List<JSONObject> logs = (List<JSONObject>) JSONObject.parseObject(msgStr, List.class);
    }
}
*/
