---
title: 用户相关
icon: users
---

::: warning 注意
对于 Shamrock 尚未实现的 API，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

## 删除好友 <Badge text="未实现" type="danger" />

该接口用于删除好友。

### API 端点

`/delete_friend`

### 参数

| 字段名    | 数据类型 | 默认值 | 说明       |
| --------- | -------- | ------ | ---------- |
| `user_id` | int64    | -      | 好友 QQ 号 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。

## 删除单向好友 <Badge text="未实现" type="danger" />

该接口用于删除单向好友。

### API 端点

`/delete_unidirectional_friend`

### 参数

| 字段      | 类型  | 说明         |
| --------- | ----- | ------------ |
| `user_id` | int64 | 单向好友QQ号 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。


## 点赞资料卡

### API 端点

`send_like`

### 参数

| 字段 | 类型   | 必须 | 说明   |
| ---- | ------ | ---- | ------ |
| time | int32 | 是 | 点赞次数 |
| user_id | int64 | 是 | 点赞的目标用户 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。