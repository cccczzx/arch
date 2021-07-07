package com.zhangzixiang.bridge.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArchAssetTypeInVo {

    @ApiModelProperty(name="id", value = "主键")
    private Integer id ;

    @ApiModelProperty(name = "typeName", value = "传感器类型名称" )
    private String typeName ;

    @ApiModelProperty(name="unit", value = "传感器数据单位")
    private String unit ;

    @ApiModelProperty(name="bridgeName", value="桥梁名称")
    private String bridgeName ;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime ;

    @ApiModelProperty(name="createUserId", value = "创建者id")
    private Integer createUserId ;

    @ApiModelProperty(name="createUserName", value = "创建者姓名")
    private String createUserName ;

    @ApiModelProperty(name="updateTime", value="更新时间")
    private Date updateTime ;

    @ApiModelProperty(name="updateUserId", value = "更新者id")
    private Integer updateUserId ;

    @ApiModelProperty(name="updateUserName", value = "更新者姓名")
    private String updateUserName ;


}
