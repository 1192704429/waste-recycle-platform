package com.grabge.server.controller;

import com.grabge.server.common.BaseController;
import com.grabge.server.common.ReturnMsg;
import com.grabge.server.dto.SuggestDTO;
import com.grabge.server.service.SuggestService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.grabge.server.common.BaseSelectEntity;
import java.util.ArrayList;
import com.grabge.server.service.UsersService;
import com.grabge.server.dto.UsersDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.grabge.server.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 反馈建议对外接口层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@RestController
@RequestMapping("/suggest")
public class SuggestController extends BaseController<SuggestService, SuggestDTO> {

    @Autowired
    private UsersService usersService;

    @Override
    @Resource(name = "suggestService")
    protected void setBaseService(SuggestService suggestService) {
        this.baseService = suggestService;
    }

    /**
    * 默认分页查询
    * @param suggestDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody SuggestDTO suggestDTO) {
        return ReturnMsg.ok(baseService.basePage(suggestDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param suggestDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody SuggestDTO suggestDTO) {
        return ReturnMsg.ok(baseService.findList(suggestDTO));
    }

    @Override
    protected void beforeSave(SuggestDTO entity) throws Exception {
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

}

