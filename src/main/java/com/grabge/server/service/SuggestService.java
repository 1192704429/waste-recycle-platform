package com.grabge.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.grabge.server.dto.SuggestDTO;
import java.util.List;
/**
* @description: 反馈建议业务层接口
* @author: wuming
* @create: 2025.02.17 15:24:23
*/
public interface SuggestService extends IService<SuggestDTO> {

    /**
    * 默认分页方法
    * @param suggestDTO
    * @return
    */
    Page<SuggestDTO> basePage(SuggestDTO suggestDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param suggestDTO
    * @return
    */
    List<SuggestDTO> findList(SuggestDTO suggestDTO);

}
