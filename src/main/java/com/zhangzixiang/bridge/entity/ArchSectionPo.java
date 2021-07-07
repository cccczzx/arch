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
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name="arch_section")
@TableName(value="arch_section")
public class ArchSectionPo implements Serializable {

    private static final long serialVersionUID = -9087747011816184437L;

    /**
     * 主键
     * */
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    /**
     * 截面名称
     * */
    @Column(name="section_name")
    private String sectionName ;

    /**
     * 符号
     * */
    @Column(name="note")
    private String note ;

    /**
     * 创建时间
     * */
    @Column(name="create_time")
    private Date createTime ;

    /**
     * 创建用户id
     * */
    @Column(name="create_user_id")
    private Integer createUserId ;

    /**
     * 创建用户名称
     * */
    @Column(name="create_user_name")
    private String createUserName ;

    /**
     * 更新时间
     * */
    @Column(name="update_time")
    private Date updateTime ;

    /**
     * 更新用户id
     * */
    @Column(name="update_user_id")
    private  Integer updateUserId ;

    /**
     * 更新用户姓名
     * */
    @Column(name="update_user_name")
    private String updateUserName ;

    /**
     * 桥名
     * */
    @Column(name="bridge_name")
    private String bridgeName ;


}
