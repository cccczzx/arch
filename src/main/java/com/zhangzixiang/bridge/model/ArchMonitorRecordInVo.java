package com.zhangzixiang.bridge.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArchMonitorRecordInVo {

    @ApiModelProperty(name="id", value = "主键")
    private Integer id ;

    @ApiModelProperty(name="fileName", value = "文件名")
    private String fileName ;

    @ApiModelProperty(name="createTime", value = "创建时间")
    private Date createTime ;

    @ApiModelProperty(name="updateTime", value = "更新时间")
    private Date updateTime ;

}
