package com.grabge.server.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.grabge.server.entity. Orders;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 回收订单数据传输层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Data
@ToString
@TableName("orders")
public class OrdersDTO extends Orders {

    /**
    * 回收员姓名
    */
    @TableField(exist = false)
    private String nickName;
    /**
    * 联系方式
    */
    @TableField(exist = false)
    private String tel;
    /**
    * 客户姓名
    */
    @TableField(exist = false)
    private String name;
    /**
    * 客户头像
    */
    @TableField(exist = false)
    private String headImg;

}
