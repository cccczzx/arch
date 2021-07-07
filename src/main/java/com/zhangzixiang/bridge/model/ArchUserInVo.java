package com.zhangzixiang.bridge.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArchUserInVo {

    @ApiModelProperty(name="id", value = "主键")
    private Integer id ;

    @ApiModelProperty(name="nickName", value = "昵称")
    private String nickName ;

    @ApiModelProperty(name="name", value = "用户姓名")
    private String name ;

    @ApiModelProperty(name="password", value = "密码")
    private String password ;

    @ApiModelProperty(name="phone", value = "手机")
    private String phone ;

    @ApiModelProperty(name="createTime", value = "创建时间")
    private Date createTime ;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime ;

    @ApiModelProperty(name="isDelete", value = "是否删除，0否1是")
    private Integer isDelete ;

}
