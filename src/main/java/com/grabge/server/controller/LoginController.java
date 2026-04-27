package com.grabge.server.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.grabge.server.common.ReturnMsg;
import com.grabge.server.dto.AdminsDTO;
import com.grabge.server.dto.RecycleDTO;
import com.grabge.server.service.AdminsService;
import com.grabge.server.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 后台管理登录控制器
 * @author: wuming
 * @Create: 2025.02.17 15:24:23
 */
@RestController
@RequestMapping("/manage/login")
public class LoginController {

    static Map<String, String> userInfoMap = new HashMap<>();

    @Autowired
    private AdminsService adminsService;

    @Autowired
    private RecycleService recycleService;

    @PostMapping
    public ReturnMsg manageLogin(@RequestBody Map<String, String> param) {
        if (StrUtil.isEmpty(param.get("username")) || StrUtil.isEmpty(param.get("password"))) {
            return ReturnMsg.error("用户名或密码错误!");
        }
        Map<String, String> returnMap = new HashMap<>();
        String type = param.get("type");
        if (type.equals("1")) {
            AdminsDTO adminsDTO = new AdminsDTO();
            adminsDTO.setUserName(param.get("username"));
            adminsDTO.setPassWord(param.get("password"));
            QueryWrapper<AdminsDTO> adminsDTOQueryWrapper = new QueryWrapper<>(adminsDTO);
            adminsDTOQueryWrapper.last("limit 1");
            AdminsDTO adminDTOS = adminsService.getOne(adminsDTOQueryWrapper);
            if (adminDTOS == null) return ReturnMsg.error("用户名或密码错误!");
            Map<String, Object> map = new HashMap<>();
            map.put("avatar", StrUtil.isNotBlank(adminDTOS.getHeadImg()) ? adminDTOS.getHeadImg() : "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            map.put("introduction", adminDTOS.getNickName() + ",你好!");
            map.put("name", adminDTOS.getNickName());
            map.put("id", adminDTOS.getId());
            map.put("roles", Arrays.asList("admin"));
            map.put("type", 1);
            String uuid = UUID.randomUUID().toString();
            returnMap.put("token", uuid);
            userInfoMap.put(uuid, JSON.toJSONString(map));
        } else {
            RecycleDTO adminsDTO = new RecycleDTO();

            adminsDTO.setAccount(param.get("username"));
            adminsDTO.setPwd(param.get("password"));
            QueryWrapper<RecycleDTO> adminsDTOQueryWrapper = new QueryWrapper<>(adminsDTO);
            adminsDTOQueryWrapper.last("limit 1");
            RecycleDTO adminDTOS = recycleService.getOne(adminsDTOQueryWrapper);
            if (adminDTOS == null) return ReturnMsg.error("用户名或密码错误!");
            if (adminDTOS.getStatus() != 1) return ReturnMsg.error("账号已停用，请联系管理员!");
            Map<String, Object> map = new HashMap<>();
            map.put("avatar", StrUtil.isNotBlank(adminDTOS.getAvatar()) ? adminDTOS.getAvatar() : "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            map.put("introduction", adminDTOS.getNickName() + ",你好!");
            map.put("name", adminDTOS.getNickName());
            map.put("id", adminDTOS.getId());
            map.put("roles", Arrays.asList("admin"));
            map.put("type", 2);
            String uuid = UUID.randomUUID().toString();
            returnMap.put("token", uuid);
            userInfoMap.put(uuid, JSON.toJSONString(map));
        }


        return ReturnMsg.ok(returnMap);
    }

    @GetMapping
    public ReturnMsg getUserInfo(@RequestParam("token") String token) {
        if (!userInfoMap.containsKey(token)) return ReturnMsg.error(401, "尚未登录,请重新登录!");
        return ReturnMsg.ok(JSON.parse(userInfoMap.get(token)));
    }

    @GetMapping("/logout")
    public ReturnMsg logout(@RequestParam("token") String token) {
        userInfoMap.remove(token);
        return ReturnMsg.ok();
    }

}
