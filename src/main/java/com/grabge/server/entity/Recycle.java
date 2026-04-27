package com.grabge.server.entity;

import com.grabge.server.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 回收员管理实体类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Recycle extends BaseEntity {

    /**
    * 编号
    */
    private Long id;
    /**
    * 姓名
    */
    private String nickName;
    /**
    * 性别
    */
    private Integer recycleSex;
    /**
    * 年龄
    */
    private Integer recycleAge;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 联系方式
    */
    private String tel;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 账号
    */
    private String account;
    /**
    * 密码
    */
    private String pwd;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
