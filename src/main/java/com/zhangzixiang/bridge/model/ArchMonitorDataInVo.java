package com.zhangzixiang.bridge.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArchMonitorDataInVo {

    @ApiModelProperty(name="id", value = "主键")
    private Integer id ;

    @ApiModelProperty(name = "assetName", value = "设备名称")
    private String assetName ;

    @ApiModelProperty(name="createTime", value = "创建时间")
    private Date createTime ;

    @ApiModelProperty(name="updateTime", value = "更新时间")
    private Date updateTime ;

    @ApiModelProperty(name="value", value = "数据")
    private double value ;


}
