package com.hz.boot01.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Provider",description = "供应商类")
public class Provider implements Serializable {
	@ApiModelProperty(value = "id",name = "id")
	private Integer id;   //id
	@ApiModelProperty(name = "proCode",value = "供应商编码")
	private String proCode; //供应商编码
	private String proName; //供应商名称
	private String proDesc; //供应商描述
	private String proContact; //供应商联系人
	private String proPhone; //供应商电话
	private String proAddress; //供应商地址
	private String proFax; //供应商传真
	private Integer createdBy; //创建者
	private String creationDate; //创建时间
	private Integer modifyBy; //更新者
	private String modifyDate;//更新时间


	
	
}
