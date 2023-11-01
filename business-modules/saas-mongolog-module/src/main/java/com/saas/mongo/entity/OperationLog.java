package com.saas.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "operation_log")
public class OperationLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value = "log_operator_id")
	private String logOperatorId;
	
	@Field(value = "log_operator_department_name")
	private String logOperatorDepartmentName;
	
	@Field(value = "log_operator_name")
	private String logOperatorName;
	
	@Field(value = "log_operate_time")
	private Date logOperateTime;
	
	@Field(value = "order_id")
	private String orderId;
	
	@Field(value = "log_operate_item_desc")
	private String logOperateItemDesc;
	
	@Field(value = "log_operate_type_desc")
	private String logOperateTypeDesc;
	
	@Field(value = "log_operate_action_name")
	private String logOperateActionName;
	
	@Field(value = "log_operate_action_desc")
	private String logOperateActionDesc;
	
	@Field(value = "primary_key_name")
	private String primaryKeyName;
	
	@Field(value = "primary_key_value")
	private String primaryKeyValue;
	
	@Field(value = "log_operate_field_belong_desc")
	private String logOperateFieldBelongDesc;
	
	@Field(value = "log_operate_show")
	private boolean logOperateShow;   
	
	@Field(value = "log_operate_old_value")
	private String logOperateOldValue;
	
	@Field(value = "log_operate_value")
	private String logOperateValue;
	
	@Field(value = "log_operate_field")
	private String logOperateField;
	
	@Field(value = "log_operate_field_belong")
	private String logOperateFieldBelong;
	
	@Field(value = "log_operate_field_desc")
	private String logOperateFieldDesc;

	@Field(value = "log_operate_company_name")
	private String logOperatorCompanyName;


}
