package com.grabge.server.dao;

import com.grabge.server.common.BaseDao;
import com.grabge.server.dto.DataDTO;
import com.grabge.server.dto.UsersDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @description: 用户管理持久层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
public interface UsersDao extends BaseDao<UsersDTO> {

    @Select("select CASE sex  WHEN 0 THEN '女'  WHEN 1 THEN '男'  END AS name,count(*) as value from users where sex is not null group by sex;")
    List<DataDTO> getNumBySex();
}
