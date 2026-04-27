package com.grabge.server.entity;

import com.grabge.server.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 用户管理实体类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users extends BaseEntity {

    /**
    * 用户编号
    */
    private Long id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 账号
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 头像
    */
    private String headImg;
    /**
    * 联系方式
    */
    private String phone;
    /**
    * 住址
    */
    private String address;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
