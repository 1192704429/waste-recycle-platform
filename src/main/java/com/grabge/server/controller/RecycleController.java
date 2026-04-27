package com.grabge.server.controller;

import com.grabge.server.common.BaseController;
import com.grabge.server.common.ReturnMsg;
import com.grabge.server.dto.RecycleDTO;
import com.grabge.server.service.RecycleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.grabge.server.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 回收员管理对外接口层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@RestController
@RequestMapping("/recycle")
public class RecycleController extends BaseController<RecycleService, RecycleDTO> {


    @Override
    @Resource(name = "recycleService")
    protected void setBaseService(RecycleService recycleService) {
        this.baseService = recycleService;
    }

    /**
    * 默认分页查询
    * @param recycleDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody RecycleDTO recycleDTO) {
        return ReturnMsg.ok(baseService.basePage(recycleDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param recycleDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody RecycleDTO recycleDTO) {
        return ReturnMsg.ok(baseService.findList(recycleDTO));
    }

    @Override
    protected void beforeSave(RecycleDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

