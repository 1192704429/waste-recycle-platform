package com.grabge.server.entity;

import com.grabge.server.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 回收订单实体类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders extends BaseEntity {

    /**
    * 订单编号
    */
    private Long id;
    /**
    * 订单号
    */
    private String orderNo;
    /**
    * 下单用户
    */
    private Long userId;
    /**
    * 预约开始时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subTimeStart;
    /**
    * 预约结束时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subTimeEnd;
    /**
    * 内容
    */
    private String info;
    /**
    * 回收员编号
    */
    private Long recycleId;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 取货地址
    */
    private String address;
    /**
    * 联系方式
    */
    private String phone;


}
