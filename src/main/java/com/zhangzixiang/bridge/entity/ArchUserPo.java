package com.zhangzixiang.bridge.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name="arch_user")
@TableName(value = "arch_user")
public class ArchUserPo implements Serializable {

    private static final long serialVersionUID = 4055783081660497832L;

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id ;

    /**
     * 昵称
     * */
    @Column(name="nick_name")
    private  String nickName ;

    /**
     * 姓名
     * */
    @Column(name="name")
    private String name ;

    /**
     * 密码
     * */
    @Column(name="password")
    private String password ;

    /**
     * 手机
     */
    @Column(name="phone")
    private String phone ;

    /**
     * 创建时间
     * */
    @Column(name="create_time")
    private Date createTime ;

    /**
     * 更新时间
     * */
    @Column(name="update_time")
    private Date updateTime ;

    /**
     * 是否删除，0否1是
     * */
    @Column(name="is_delete")
    private Integer isDelete ;




}
