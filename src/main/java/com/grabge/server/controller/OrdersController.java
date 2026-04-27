package com.grabge.server.controller;

import cn.hutool.core.util.IdUtil;
import com.grabge.server.common.BaseController;
import com.grabge.server.common.BaseSelectEntity;
import com.grabge.server.common.ReturnMsg;
import com.grabge.server.dto.OrdersDTO;
import com.grabge.server.dto.RecycleDTO;
import com.grabge.server.dto.UsersDTO;
import com.grabge.server.service.OrdersService;
import com.grabge.server.service.RecycleService;
import com.grabge.server.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 回收订单对外接口层
 * @author: wuming
 * @create: 2025.02.17 15:24:23
 */
@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseController<OrdersService, OrdersDTO> {

    @Autowired
    private UsersService usersService;
    @Autowired
    private RecycleService recycleService;

    @Override
    @Resource(name = "ordersService")
    protected void setBaseService(OrdersService ordersService) {
        this.baseService = ordersService;
    }

    /**
     * 默认分页查询
     *
     * @param ordersDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody OrdersDTO ordersDTO) {
        return ReturnMsg.ok(baseService.basePage(ordersDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param ordersDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody OrdersDTO ordersDTO) {
        return ReturnMsg.ok(baseService.findList(ordersDTO));
    }

    @Override
    protected void beforeSave(OrdersDTO entity) throws Exception {
        entity.setOrderNo(IdUtil.fastUUID().substring(0,10));
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/users")
    public ReturnMsg allUsers() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<UsersDTO> dtos = usersService.list();
        for (UsersDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

    @GetMapping("/all/recycle")
    public ReturnMsg allRecycle() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<RecycleDTO> dtos = recycleService.list();
        for (RecycleDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getNickName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

