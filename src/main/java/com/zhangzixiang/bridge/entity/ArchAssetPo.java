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
@Table (name="arch_asset")
@TableName (value="arch_asset")
public class ArchAssetPo implements Serializable {

    private static final long serialVersionUID = -1784009464280819601L;

    /**
     * 主键
     * */
    @Column (name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 桥梁名
     * */
    @Column(name="asset_name")
    private String assetName ;

    /**
     * 截面编号
     * */
    @Column(name="section_id")
    private Integer sectionId ;

    /**
     * 截面名称
     * */
    @Column(name="section_name")
    private String sectionName ;

    /**
     * 文件夹名称
     * */
    @Column(name="folder_name")
    private String folderName ;

    /**
     * 启用标识 0否1是
     * */
    @Column(name="enable_flag")
    private Integer enableFlag ;

    /**
     * 桥梁设备状态
     * */
    @Column(name="monitor_state")
    private String monitorState ;

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

    /**
     * 设备类型id
     * */
    @Column(name="type_id")
    private Integer typeId ;

    /**
     * 监测方向（如有）
     * */
    @Column(name="direction")
    private String direction ;

    /**
     * 桥名
     * */
    @Column(name="bridge_name")
    private String bridgeName ;

}
