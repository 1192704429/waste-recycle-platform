package com.grabge.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.grabge.server.dto.SitesDTO;
import java.util.List;
/**
* @description: 站点管理业务层接口
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
public interface SitesService extends IService<SitesDTO> {

    /**
    * 默认分页方法
    * @param sitesDTO
    * @return
    */
    Page<SitesDTO> basePage(SitesDTO sitesDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param sitesDTO
    * @return
    */
    List<SitesDTO> findList(SitesDTO sitesDTO);

}
