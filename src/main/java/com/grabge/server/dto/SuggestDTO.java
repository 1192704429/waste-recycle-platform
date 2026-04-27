package com.grabge.server.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.grabge.server.entity. Suggest;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 反馈建议数据传输层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Data
@ToString
@TableName("suggest")
public class SuggestDTO extends Suggest {

    /**
    * 姓名
    */
    @TableField(exist = false)
    private String name;
    /**
    * 头像
    */
    @TableField(exist = false)
    private String headImg;

}
