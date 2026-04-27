package com.grabge.server.controller;

import com.grabge.server.common.BaseController;
import com.grabge.server.common.ReturnMsg;
import com.grabge.server.dto.NoticeDTO;
import com.grabge.server.service.NoticeService;
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
* @description: 公告管理对外接口层
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController<NoticeService, NoticeDTO> {


    @Override
    @Resource(name = "noticeService")
    protected void setBaseService(NoticeService noticeService) {
        this.baseService = noticeService;
    }

    /**
    * 默认分页查询
    * @param noticeDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody NoticeDTO noticeDTO) {
        return ReturnMsg.ok(baseService.basePage(noticeDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param noticeDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody NoticeDTO noticeDTO) {
        return ReturnMsg.ok(baseService.findList(noticeDTO));
    }

    @Override
    protected void beforeSave(NoticeDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

