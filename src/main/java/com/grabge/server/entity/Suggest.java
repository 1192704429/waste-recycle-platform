package com.grabge.server.entity;

import com.grabge.server.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 反馈建议实体类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Suggest extends BaseEntity {

    /**
    * 建议编号
    */
    private Long id;
    /**
    * 所属用户
    */
    private Long userId;
    /**
    * 内容
    */
    private String content;
    /**
    * 管理员回复
    */
    private String adminInfo;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
