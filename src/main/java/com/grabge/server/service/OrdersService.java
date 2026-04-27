package com.grabge.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.grabge.server.dto.DataDTO;
import com.grabge.server.dto.OrdersDTO;
import java.util.List;
/**
* @description: 回收订单业务层接口
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
public interface OrdersService extends IService<OrdersDTO> {

    /**
    * 默认分页方法
    * @param ordersDTO
    * @return
    */
    Page<OrdersDTO> basePage(OrdersDTO ordersDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param ordersDTO
    * @return
    */
    List<OrdersDTO> findList(OrdersDTO ordersDTO);

    List<DataDTO> getMoneyNum(Integer day);
}
