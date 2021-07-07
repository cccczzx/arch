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
@Table(name="arch_monitor_data")
@TableName(value="arch_monitor_data")
public class ArchMonitorDataPo implements Serializable {

    private static final long serialVersionUID = -6382052862568797367L;

    /**
     * 主键
     * */
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 设备名称
     * */
    @Column(name="asset_name")
    private String assetName ;

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
     * 取值
     * */
    @Column(name="value")
    private double value ;

}
