package com.grabge.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grabge.server.dao.SuggestDao;
import com.grabge.server.dto.SuggestDTO;
import com.grabge.server.service.SuggestService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 反馈建议业务层实现类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Service("suggestService")
public class SuggestServiceImpl extends ServiceImpl<SuggestDao, SuggestDTO> implements SuggestService {

    @Override
    public Page<SuggestDTO> basePage(SuggestDTO suggestDTO) {
        if (null != suggestDTO.getCurrent() && null != suggestDTO.getPageSize())
            suggestDTO.setCurrent((suggestDTO.getCurrent() - 1) * suggestDTO.getPageSize());
        List<SuggestDTO> list = this.baseMapper.findList(suggestDTO);
        int count = this.baseMapper.findPageCount(suggestDTO);
        Page<SuggestDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<SuggestDTO> findList(SuggestDTO suggestDTO) {
        return this.baseMapper.findList(suggestDTO);
    }

}
