package com.grabge.server.controller;

import com.grabge.server.common.BaseController;
import com.grabge.server.common.ReturnMsg;
import com.grabge.server.dto.SitesDTO;
import com.grabge.server.service.SitesService;
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
* @description: 站点管理对外接口层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@RestController
@RequestMapping("/sites")
public class SitesController extends BaseController<SitesService, SitesDTO> {


    @Override
    @Resource(name = "sitesService")
    protected void setBaseService(SitesService sitesService) {
        this.baseService = sitesService;
    }

    /**
    * 默认分页查询
    * @param sitesDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody SitesDTO sitesDTO) {
        return ReturnMsg.ok(baseService.basePage(sitesDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param sitesDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody SitesDTO sitesDTO) {
        return ReturnMsg.ok(baseService.findList(sitesDTO));
    }

    @Override
    protected void beforeSave(SitesDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

