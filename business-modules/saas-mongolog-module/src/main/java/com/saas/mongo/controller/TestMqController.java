package com.saas.mongo.controller;


import com.pub.core.util.controller.BaseController;
import com.pub.core.util.domain.AjaxResult;
import com.pub.core.util.page.TableDataInfo;
import com.saas.mongo.entity.OperationLog;
import com.saas.mongo.repository.OperationLogRepository;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ganyongheng
 * @since 2023-08-02
 */
@Controller
@RequestMapping("/offline/goodFirstMeumDo")
public class TestMqController extends BaseController {

    /*@Autowired
    private RocketMQTemplate rocketMQTemplate;
*/
    @Autowired
    protected OperationLogRepository operationLogRepository;

/*    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;*/


   /* @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getPageList(@RequestParam String req){
        try{
            rocketMQTemplate.convertAndSend("mongolog",req);
            return AjaxResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }*/
    @RequestMapping(value = "/saveEntity", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult saveEntity(@RequestBody OperationLog req){
        try{
            operationLogRepository.insert(req);
            return AjaxResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }

 /*   @RequestMapping(value = "/sendMsgKafka", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult sendMsgKafka(@RequestParam String msg){
        try{
            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("mongologTopic", msg);            return AjaxResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }
*/
}

