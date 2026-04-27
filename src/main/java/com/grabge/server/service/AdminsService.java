package com.grabge.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.grabge.server.dto.AdminsDTO;
import java.util.List;
/**
* @description: 管理员业务层接口
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
public interface AdminsService extends IService<AdminsDTO> {

    /**
    * 默认分页方法
    * @param adminsDTO
    * @return
    */
    Page<AdminsDTO> basePage(AdminsDTO adminsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param adminsDTO
    * @return
    */
    List<AdminsDTO> findList(AdminsDTO adminsDTO);

}
