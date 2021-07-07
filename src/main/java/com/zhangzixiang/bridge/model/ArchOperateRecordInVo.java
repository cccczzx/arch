package com.zhangzixiang.bridge.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArchOperateRecordInVo {

    @ApiModelProperty (name="id", value="主键")
    private Integer id ;

    @ApiModelProperty(name="content", value = "内容")
    private String content ;

    @ApiModelProperty(name="userId", value="用户id")
    private Integer userId ;

    @ApiModelProperty(name="userName", value = "用户姓名")
    private String userName ;

    @ApiModelProperty(name="nickName", value = "用户昵称")
    private String nickName ;

    @ApiModelProperty(name="createTime", value = "创建时间")
    private Date createTime ;

    @ApiModelProperty(name="isDelete", value = "是否删除， 0否1是")
    private Integer isDelete ;

    @ApiModelProperty(name="updateTime", value = "更新时间")
    private Date updateTime ;

    @ApiModelProperty(name="updateUserId", value = "更新者id")
    private Integer updateUserId ;

    @ApiModelProperty(name="updateUserName", value = "更新者姓名")
    private String updateUserName ;

}
