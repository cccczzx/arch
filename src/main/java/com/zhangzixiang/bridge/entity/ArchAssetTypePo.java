package com.zhangzixiang.bridge.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
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
@Table (name="arch_asset_type")
@TableName (value="arch_asset_type")
public class ArchAssetTypePo implements Serializable {

    private static final long serialVersionUID = 8945066899068547451L;

    /**
     * 主键
     * */
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    /**
     * 桥梁名
     * */
    @Column(name="type_name")
    private String typeName ;

    /**
     * 单位
     * */
    @Column(name="unit")
    private String unit ;

    /**
     * 桥名
     * */
    @Column(name="bridge_name")
    private String bridgeName ;

    /**
     * 创建时间
     * */
    @Column(name="create_time")
    private Date createTime ;

    /**
     * 创建者id
     * */
    @Column(name="create_user_id")
    private Integer createUserId ;

    /**
     * 创建者姓名
     * */
    @Column(name="create_user_name")
    private String createUserName ;

    /**
     * 更新时间
     * */
    @Column(name="update_time")
    private Date updateTime ;

    /**
     * 更新者id
     * */
    @Column(name="update_user_id")
    private Integer updateUserId ;

    /**
     * 更新者姓名
     * */
    @Column(name="update_user_name")
    private String updateUserName ;


}
