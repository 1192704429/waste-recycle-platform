package com.grabge.server.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.grabge.server.entity. Notice;
import lombok.Data;
import lombok.ToString;

/**
* @description: 公告管理数据传输层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Data
@ToString
@TableName("notice")
public class NoticeDTO extends Notice {


}
