package com.grabge.server.controller;

import com.grabge.server.common.BaseController;
import com.grabge.server.common.BaseSelectEntity;
import com.grabge.server.common.ReturnMsg;
import com.grabge.server.dto.KnowledgeDTO;
import com.grabge.server.dto.TypesDTO;
import com.grabge.server.service.KnowledgeService;
import com.grabge.server.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 科普知识管理对外接口层
 * @author: wuming
 * @create: 2025.02.17 15:24:23
 */
@RestController
@RequestMapping("/knowledge")
public class KnowledgeController extends BaseController<KnowledgeService, KnowledgeDTO> {

    @Autowired
    private TypesService typesService;

    @Override
    @Resource(name = "knowledgeService")
    protected void setBaseService(KnowledgeService knowledgeService) {
        this.baseService = knowledgeService;
    }

    /**
     * 默认分页查询
     *
     * @param knowledgeDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody KnowledgeDTO knowledgeDTO) {
        return ReturnMsg.ok(baseService.basePage(knowledgeDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param knowledgeDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody KnowledgeDTO knowledgeDTO) {
        return ReturnMsg.ok(baseService.findList(knowledgeDTO));
    }

    @GetMapping("/getIndex/{num}")
    public ReturnMsg getIndex(@PathVariable int num) {
        KnowledgeDTO knowledgeDTO = new KnowledgeDTO();
        knowledgeDTO.setPageSize(num);
        knowledgeDTO.setCurrent(1);
        return ReturnMsg.ok(baseService.findList(knowledgeDTO));
    }


    @Override
    protected void beforeSave(KnowledgeDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/types")
    public ReturnMsg allTypes() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<TypesDTO> dtos = typesService.list();
        for (TypesDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getTypeName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

