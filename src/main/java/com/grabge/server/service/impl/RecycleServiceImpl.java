package com.grabge.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grabge.server.dao.RecycleDao;
import com.grabge.server.dto.RecycleDTO;
import com.grabge.server.service.RecycleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 回收员管理业务层实现类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Service("recycleService")
public class RecycleServiceImpl extends ServiceImpl<RecycleDao, RecycleDTO> implements RecycleService {

    @Override
    public Page<RecycleDTO> basePage(RecycleDTO recycleDTO) {
        if (null != recycleDTO.getCurrent() && null != recycleDTO.getPageSize())
            recycleDTO.setCurrent((recycleDTO.getCurrent() - 1) * recycleDTO.getPageSize());
        List<RecycleDTO> list = this.baseMapper.findList(recycleDTO);
        int count = this.baseMapper.findPageCount(recycleDTO);
        Page<RecycleDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<RecycleDTO> findList(RecycleDTO recycleDTO) {
        return this.baseMapper.findList(recycleDTO);
    }

}
