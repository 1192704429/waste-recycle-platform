package com.grabge.server.dao;

import com.grabge.server.common.BaseDao;
import com.grabge.server.dto.DataDTO;
import com.grabge.server.dto.OrdersDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @description: 回收订单持久层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
public interface OrdersDao extends BaseDao<OrdersDTO> {

    @Select("SELECT DATE( create_time ) AS NAME,count( * ) AS  VALUE FROM orders WHERE create_time >= NOW( ) - INTERVAL #{num} DAY GROUP BY DATE(create_time) ORDER BY name")
    List<DataDTO> getMoneyNum(@Param("num") int num);
}
