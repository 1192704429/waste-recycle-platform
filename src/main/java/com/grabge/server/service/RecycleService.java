package com.grabge.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.grabge.server.dto.RecycleDTO;
import java.util.List;
/**
* @description: 回收员管理业务层接口
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
public interface RecycleService extends IService<RecycleDTO> {

    /**
    * 默认分页方法
    * @param recycleDTO
    * @return
    */
    Page<RecycleDTO> basePage(RecycleDTO recycleDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param recycleDTO
    * @return
    */
    List<RecycleDTO> findList(RecycleDTO recycleDTO);

}
