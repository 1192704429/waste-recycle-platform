package com.grabge.server.entity;

import com.grabge.server.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 站点管理实体类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sites extends BaseEntity {

    /**
    * 站点编号
    */
    private Long id;
    /**
    * 站点名称
    */
    private String name;
    /**
    * 站点简介
    */
    private String info;
    /**
    * 所处位置
    */
    private String address;
    /**
    * 封面图
    */
    private String bannerImg;
    /**
    * 站点状态
    */
    private Integer status;
    /**
    * 经度
    */
    private String longitude;
    /**
    * 纬度
    */
    private String latitude;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
