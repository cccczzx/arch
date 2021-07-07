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
@Table (name="arch_operate_record")
@TableName (value = "arch_operate_record")
public class ArchOperateRecordPo implements Serializable {

    private static final long serialVersionUID = 1215152433310537647L;

    /**
     * 主键
     * */
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    /**
     * 内容
     * */
    @Column(name="content")
    private String content ;

    /**
     * 用户id
     * */
    @Column(name="user_id")
    private Integer userId ;

    /**
     * 用户姓名
     * */
    @Column(name="user_name")
    private String userName ;

    /**
     * 昵称
     * */
    @Column(name="nick_name")
    private String nickName ;

    /**
     * 创建时间
     * */
    @Column(name="create_time")
    private Date createTime ;

    /**
     * 是否删除，0否1是
     * */
    @Column(name="is_delete")
    private Integer is_delete ;

    /**
     * 更新时间
     * */
    @Column(name="update_time")
    private String updateTime ;

    /**
     * 更新用户id
     * */
    @Column(name="update_user_id")
    private Integer updateUserId ;

    /**
     * 更新用户名称
     * */
    @Column(name="update_user_name")
    private String updateUserName ;



}
