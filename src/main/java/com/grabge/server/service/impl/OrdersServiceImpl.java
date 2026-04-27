package com.grabge.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grabge.server.dao.OrdersDao;
import com.grabge.server.dto.DataDTO;
import com.grabge.server.dto.OrdersDTO;
import com.grabge.server.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 回收订单业务层实现类
 * @author: wuming
 * @create: 2025.02.17 15:24:23
 */
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersDTO> implements OrdersService {

    @Override
    public Page<OrdersDTO> basePage(OrdersDTO ordersDTO) {
        if (null != ordersDTO.getCurrent() && null != ordersDTO.getPageSize())
            ordersDTO.setCurrent((ordersDTO.getCurrent() - 1) * ordersDTO.getPageSize());
        List<OrdersDTO> list = this.baseMapper.findList(ordersDTO);
        int count = this.baseMapper.findPageCount(ordersDTO);
        Page<OrdersDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<OrdersDTO> findList(OrdersDTO ordersDTO) {
        return this.baseMapper.findList(ordersDTO);
    }

    @Override
    public List<DataDTO> getMoneyNum(Integer day) {
        return this.baseMapper.getMoneyNum(day);
    }

}
