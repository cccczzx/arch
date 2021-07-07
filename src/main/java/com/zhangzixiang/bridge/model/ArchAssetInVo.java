package com.zhangzixiang.bridge.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArchAssetInVo {

    @ApiModelProperty (name="id", value = "主键")
    private Integer id ;

    @ApiModelProperty(name="assetName", value = "设备名称")
    private String assetName ;

    @ApiModelProperty(name="sectionId", value = "截面编号")
    private Integer sectionId ;

    @ApiModelProperty(name="sectionName", value="截面名称")
    private String sectionName ;

    @ApiModelProperty(name="folderName", value = "文件夹名称")
    private String folderName ;

    @ApiModelProperty(name="enableFlag", value = "启用标识，0未启用，1启用")
    private Integer enableFlag ;

    @ApiModelProperty(name="monitorState", value = "桥梁设备状态")
    private String monitorState ;

    @ApiModelProperty(name="createTime", value = "创建时间")
    private Date createTime ;

    @ApiModelProperty(name="createUserId", value = "创建者id")
    private Integer createUserId ;

    @ApiModelProperty(name="createUserName", value = "创建者姓名")
    private String createUserName ;

    @ApiModelProperty(name="updateTime", value = "更新时间")
    private Date updateTime ;

    @ApiModelProperty(name="updateUserId", value = "更新者id")
    private Integer updateUserId ;

    @ApiModelProperty(name="updateUserName", value = "更新者姓名")
    private  String updateUserName ;

    @ApiModelProperty(name="typeId", value = "传感器类型id")
    private Integer typeId ;

    @ApiModelProperty(name="direction", value = "监测方向（如有）")
    private Integer direction ;

    @ApiModelProperty(name="bridgeName", value = "桥名")
    private String bridgeName ;

}
