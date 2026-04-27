package com.grabge.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grabge.server.dao.SitesDao;
import com.grabge.server.dto.SitesDTO;
import com.grabge.server.service.SitesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 站点管理业务层实现类
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
@Service("sitesService")
public class SitesServiceImpl extends ServiceImpl<SitesDao, SitesDTO> implements SitesService {

    @Override
    public Page<SitesDTO> basePage(SitesDTO sitesDTO) {
        if (null != sitesDTO.getCurrent() && null != sitesDTO.getPageSize())
            sitesDTO.setCurrent((sitesDTO.getCurrent() - 1) * sitesDTO.getPageSize());
        List<SitesDTO> list = this.baseMapper.findList(sitesDTO);
        int count = this.baseMapper.findPageCount(sitesDTO);
        Page<SitesDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<SitesDTO> findList(SitesDTO sitesDTO) {
        return this.baseMapper.findList(sitesDTO);
    }

}
