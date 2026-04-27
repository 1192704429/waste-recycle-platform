package com.grabge.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grabge.server.dao.KnowledgeDao;
import com.grabge.server.dto.KnowledgeDTO;
import com.grabge.server.service.KnowledgeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 科普知识管理业务层实现类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Service("knowledgeService")
public class KnowledgeServiceImpl extends ServiceImpl<KnowledgeDao, KnowledgeDTO> implements KnowledgeService {

    @Override
    public Page<KnowledgeDTO> basePage(KnowledgeDTO knowledgeDTO) {
        if (null != knowledgeDTO.getCurrent() && null != knowledgeDTO.getPageSize())
            knowledgeDTO.setCurrent((knowledgeDTO.getCurrent() - 1) * knowledgeDTO.getPageSize());
        List<KnowledgeDTO> list = this.baseMapper.findList(knowledgeDTO);
        int count = this.baseMapper.findPageCount(knowledgeDTO);
        Page<KnowledgeDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<KnowledgeDTO> findList(KnowledgeDTO knowledgeDTO) {
        return this.baseMapper.findList(knowledgeDTO);
    }

}
