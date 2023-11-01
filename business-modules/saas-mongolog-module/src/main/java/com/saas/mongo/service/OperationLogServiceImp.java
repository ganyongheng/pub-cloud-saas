package com.saas.mongo.service;

import com.alibaba.fastjson2.JSONObject;
import com.pub.core.utils.StringUtils;
import com.saas.mongo.entity.OperationLog;
import com.saas.mongo.repository.OperationLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Slf4j
@Service
public class OperationLogServiceImp {

    @Autowired
    protected OperationLogRepository operationLogRepository;


    public void saveLog(List<JSONObject> logs){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<OperationLog> logLists = new ArrayList<OperationLog>();
        for (JSONObject js : logs) {
            if(StringUtils.isBlank(js.getString("orderId") )){
                continue;
            }
            Boolean logOperateShow = js.getBoolean("logOperateShow");
            String uuidKey = js.getString("UuidKey");
            if(logOperateShow!=null&&logOperateShow&&StringUtils.isNotBlank(uuidKey)) {
                try {
                    OperationLog log = new OperationLog();

                    log.setId(uuidKey);
                    String orderId = js.getString("orderId");
                    if(StringUtils.isNotBlank(orderId)){
                        log.setOrderId(orderId);
                    }

                    String logOperatorId = js.getString("logOperatorId");
                    if(StringUtils.isNotBlank(logOperatorId)){
                        log.setLogOperatorId(logOperatorId);
                    }

                    String logOperatorName = js.getString("logOperatorName");
                    if(StringUtils.isNotBlank(logOperatorName)){
                        log.setLogOperatorName(logOperatorName);
                    }

                    String logOperatorDepartmentName = js.getString("logOperatorDepartmentName");
                    if(StringUtils.isNotBlank(logOperatorDepartmentName)){
                        log.setLogOperatorDepartmentName(logOperatorDepartmentName);
                    }

                    String logOperateTime = js.getString("logOperateTime");
                    if(StringUtils.isNotBlank(logOperateTime)){
                        log.setLogOperateTime(sdf.parse(logOperateTime));
                    }

                    String logOperateItemDesc = js.getString("logOperateItemDesc");
                    if(StringUtils.isNotBlank(logOperateItemDesc)){
                        log.setLogOperateItemDesc(logOperateItemDesc);
                    }

                    String logOperateTypeDesc = js.getString("logOperateTypeDesc");
                    if(StringUtils.isNotBlank(logOperateTypeDesc)){
                        log.setLogOperateTypeDesc(logOperateTypeDesc);
                    }
                    String logOperateActionName = js.getString("logOperateActionName");
                    if(StringUtils.isNotBlank(logOperateActionName)){
                        log.setLogOperateActionName(logOperateActionName);
                    }
                    String logOperateActionDesc = js.getString("logOperateActionDesc");
                    if(StringUtils.isNotBlank(logOperateActionDesc)){
                        log.setLogOperateActionDesc(logOperateActionDesc);
                    }
                    String logOperateField = js.getString("logOperateField");
                    if(StringUtils.isNotBlank(logOperateField)){
                        log.setLogOperateField(logOperateField);
                    }
                    String logOperateFieldDesc = js.getString("logOperateFieldDesc");
                    if(StringUtils.isNotBlank(logOperateFieldDesc)){
                        log.setLogOperateFieldDesc(logOperateFieldDesc);
                    }
                    String logOperateFieldBelong = js.getString("logOperateFieldBelong");
                    if(StringUtils.isNotBlank(logOperateFieldBelong)){
                        log.setLogOperateFieldBelong(logOperateFieldBelong);
                    }
                    String logOperateFieldBelongDesc = js.getString("logOperateFieldBelongDesc");
                    if(StringUtils.isNotBlank(logOperateFieldBelongDesc)){
                        log.setLogOperateFieldBelongDesc(logOperateFieldBelongDesc);
                    }
                    String logOperateOldValue = js.getString("logOperateOldValue");
                    if(StringUtils.isNotBlank(logOperateOldValue)){
                        log.setLogOperateOldValue(logOperateOldValue);
                    }
                    String logOperateValue = js.getString("logOperateValue");
                    if(StringUtils.isNotBlank(logOperateValue)){
                        log.setLogOperateValue(logOperateValue);
                    }
                    log.setLogOperateShow(logOperateShow);
                    String primaryKeyName = js.getString("primaryKeyName");
                    if(StringUtils.isNotBlank(primaryKeyName)){
                        log.setPrimaryKeyName(primaryKeyName);
                    }
                    String primaryKeyValue = js.getString("primaryKeyValue");
                    if(StringUtils.isNotBlank(primaryKeyValue)){
                        log.setPrimaryKeyValue(primaryKeyValue);
                    }
                    String logOperatorCompanyName = js.getString("logOperatorCompanyName");
                    if(StringUtils.isNotBlank(logOperatorCompanyName)){
                        log.setLogOperatorCompanyName(logOperatorCompanyName);
                    }
                    logLists.add(log);



                }catch (Exception e){
                    e.printStackTrace();
                    log.error("封装数据出错"+e.getMessage());
                }
            }else {
                log.info("日志不显示，不保存到mongodb,日志内容{}",js.toJSONString());
            }
        }

        if(logLists.size() > 0){
            try {
                operationLogRepository.saveAll(logLists);
            }catch (Exception e){
                e.printStackTrace();
                log.error("保存mgdb出错："+e.getMessage());
            }

        }
    };
}
