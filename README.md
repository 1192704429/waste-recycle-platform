# 基于 Java + SpringBoot + Vue 的废品回收平台的设计与实现

> 本文围绕城市废品回收场景，设计并实现了一套基于 Java + SpringBoot + Vue 的废品回收平台，涵盖管理员、用户、回收员三大角色，提供上门回收、站点地图、科普知识等服务，推动废品回收数字化与智能化。

## 一、项目背景

- 城市废品回收行业存在管理混乱、信息不透明、回收效率低等问题，传统回收方式难以满足居民与回收企业的需求。
- 废品回收平台通过线上预约、站点导航、科普宣传等方式，解决用户废品处理难、回收员接单不便、管理员无法实时管控痛点。
- 系统覆盖用户端、回收员端、管理端，实现废品回收全流程线上化管理，提升回收效率与用户体验。

## 二、功能模块介绍

系统分为管理端、用户端、回收员端三大端，支持不同角色的业务流程与权限管理。

| 系统端 | 角色 |
| ------ | ---- |
| 管理端 | 管理员 |
| 用户端 | 用户 |
| 回收员端 | 回收员 |


![功能模块图](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/azhou_promotion/img/module_structure/func_module_b842614d1f1a49a2b3ba1e408a5cdd12.png)


## 三、技术栈说明

前端：Vue

后端：SpringBoot

数据库与中间件：MySQL

## 四、核心模块介绍

###### 管理端

###### 管理员

| 功能点 | 描述 |
| ------ | ---- |
| 管理员登录 | 管理员账号密码登录系统 |
| 用户管理 | 查看、编辑、删除平台用户信息 |
| 回收员管理 | 为回收员分配账号、管理回收员信息 |
| 科普知识管理 | 新增、编辑、删除环保科普文章 |
| 回收站点管理 | 维护回收站点信息，支持地图标点展示 |
| 意见反馈处理 | 查看用户意见反馈并进行回复处理 |
| 上门回收订单管理 | 查看所有上门回收订单状态与详情 |
| 统计图表 | 展示最近回收订单数量等统计图形 |

##### 界面展示

登录页：管理员输入账号密码登录废品回收后台

![登录页：管理员输入账号密码登录废品回收后台](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/4bc28dda-7e0f-4a1d-8b6a-ea8670373a6d.png)

首页：展示用户信息与下单量的相关统计数据

![首页：展示用户信息与下单量的相关统计数据](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/e6d6db93-df02-457d-8f6c-372bec79cf89.png)

用户管理页：管理员对平台用户信息进行查看和管理

![用户管理页：管理员对平台用户信息进行查看和管理](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/e05f4c7e-1372-4acc-8bba-8634a4062d77.png)

回收员管理：管理员查看并管理平台的回收员信息

![回收员管理：管理员查看并管理平台的回收员信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/1d99f39a-298b-48b1-8d92-daf833573639.png)

站点管理页：管理员管理废品回收站点的相关信息

![站点管理页：管理员管理废品回收站点的相关信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/138f2e95-47f0-4ae0-8027-6cf864c13cb2.png)

回收站点管理页：管理员管理回收站点，添加新站点地图位置

![回收站点管理页：管理员管理回收站点，添加新站点地图位置](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/08280e82-90fc-42a5-8155-8c79d5069825.png)

科普知识管理：修改科普知识的标题、封面及内容信息

![科普知识管理：修改科普知识的标题、封面及内容信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/2e98216a-214d-4249-817b-c7c0eb0d69b8.png)

科普知识管理：管理科普知识分类，支持增删改查操作

![科普知识管理：管理科普知识分类，支持增删改查操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/1cde3711-bddd-4d4f-883f-00c63af3256f.png)

科普知识管理页：管理员管理平台的废品回收科普知识

![科普知识管理页：管理员管理平台的废品回收科普知识](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/a438639c-0995-4470-8f2a-58cb74f1551a.png)

订单管理页：管理员查看管理平台上门回收订单

![订单管理页：管理员查看管理平台上门回收订单](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/9fafb47a-ffe7-4596-8ad4-2a84ec91fb5e.png)

反馈管理页：查看处理用户提交的平台反馈建议

![反馈管理页：查看处理用户提交的平台反馈建议](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/b11b1e02-7e48-4e00-8a58-73e65d01c393.png)

公告管理页：管理员查看和管理平台的公告信息

![公告管理页：管理员查看和管理平台的公告信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/92970005-7e73-4545-84ee-4cfbe1fd24d5.png)


###### 用户端

###### 用户

| 功能点 | 描述 |
| ------ | ---- |
| 登录，注册 | 用户注册账号并登录系统 |
| 个人中心 | 修改个人基本信息及收货地址 |
| 查看环保科普知识 | 浏览平台发布的环保科普文章 |
| 查看社区公告 | 查看管理员发布的社区公告 |
| 上门回收 | 创建上门回收订单，填写废品信息 |
| 站点搜索，站点地图查看 | 搜索回收站点并查看站点地图位置 |
| 平台意见回馈 | 向平台提交意见与建议 |

##### 界面展示

登录页：用户输入账号密码，登录废品回收平台

![登录页：用户输入账号密码，登录废品回收平台](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/8a0d31d3-d930-4ead-86d0-c9e4572a0bcd.png)

首页：展示轮播图与环保科普知识列表

![首页：展示轮播图与环保科普知识列表](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/4a38ea00-e56a-4a50-8166-397b0248f013.png)

详情页：查看垃圾分类相关的环保科普知识详情

![详情页：查看垃圾分类相关的环保科普知识详情](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/c99dc549-1232-40c1-8293-854525b7ad73.png)

站点列表页：展示回收站点信息，支持搜索查询站点

![站点列表页：展示回收站点信息，支持搜索查询站点](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/90c5c809-5727-4757-8842-210f464988e3.png)

站点详情页：查看目标回收站点的详情信息和地图位置

![站点详情页：查看目标回收站点的详情信息和地图位置](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/3dc0d03b-5468-4bde-863b-9213e4f4607b.png)

公告详情页：展示垃圾回收平台维护通知的详细内容

![公告详情页：展示垃圾回收平台维护通知的详细内容](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/fe119368-8319-4f04-82e6-dcbe8c4f1bf8.png)

订单页：填写订单信息，新增上门废品回收订单

![订单页：填写订单信息，新增上门废品回收订单](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/9cb8be77-cc25-4864-81bc-f5483a7d7e5f.png)

订单管理页：查看管理个人的废品上门回收订单

![订单管理页：查看管理个人的废品上门回收订单](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/83bacb89-6e9d-4d3f-8efc-0151656cc5b0.png)

个人中心页：修改个人信息，提交更新个人资料

![个人中心页：修改个人信息，提交更新个人资料](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/3b770e0f-4cb9-47bc-8be3-b28aa9b4b941.png)

意见反馈页：查看个人提交的意见反馈及处理状态

![意见反馈页：查看个人提交的意见反馈及处理状态](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/81e67d06-ecb4-4cac-8701-f6d6effd56d8.png)


###### 回收员端

###### 回收员

| 功能点 | 描述 |
| ------ | ---- |
| 回收员登录 | 回收员使用管理员分配的账号登录 |
| 个人中心 | 查看与修改个人信息 |
| 接单中心 | 查看待接单的上门回收订单并接单 |
| 我的订单 | 查看自己已接单的订单状态与详情 |

##### 界面展示

接单中心页：展示可接订单，供接单员接单操作

![接单中心页：展示可接订单，供接单员接单操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/160d94f4-69ac-4969-8754-41ee71c88d02.png)

订单页：查看我承接的废品回收订单信息

![订单页：查看我承接的废品回收订单信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/d2524848-961c-4e6f-8d58-9c32b84ef34c.png)

个人中心页：修改个人信息以及修改账号登录密码

![个人中心页：修改个人信息以及修改账号登录密码](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-27/264d0c37-e490-4308-8236-f7540f3789d2.png)


## 五、主要业务流程

1. 用户注册登录系统，维护个人信息与地址。
2. 用户提交上门回收订单，填写废品类型、地址等信息。
3. 回收员登录回收员端，在接单中心查看待接单订单。
4. 回收员接单后，前往用户地址完成废品回收。
5. 管理员登录管理端，查看与管理用户、回收员、订单、站点等数据。
6. 管理员查看统计图表，分析回收订单趋势。
7. 用户可在平台提交意见反馈，管理员进行回复处理。

## 六、项目拓展性

- 可增加回收物品价格智能评估模块，根据市场行情自动生成回收报价。
- 可接入支付接口，支持在线结算回收费用，提升交易闭环。
- 可扩展回收员绩效考核与积分奖励系统，提高接单积极性。
- 可支持多语言版本，适应不同地区用户需求。
- 可增加大数据分析模块，对回收数据进行深度挖掘与趋势预测。

## 代码说明 
本仓库为项目的 **后端核心代码部分** 主要用于展示系统的业务设计思路与后端实现方式 出于学习展示与版权保护考虑 前端实现、完整数据库脚本及部署配置未在本仓库中公开 

##  项目交流 
本项目用于学习展示 如需项目完整功能演示、答辩说明或技术交流 请前往作者 GitHub 主页查看联系方式