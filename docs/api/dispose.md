---
title: 处理相关
icon: bowling-ball
---

::: warning 注意
对于 Shamrock 尚未实现的 API，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

## 处理加好友请求 <Badge text="未实现" type="danger" />

该接口用于处理加好友请求。

### API 端点

`/set_friend_add_request`

### 参数

| 字段名  | 数据类型 | 默认值 | 说明                                      |
| ------- | -------- | ------ | ----------------------------------------- |
| flag    | string   | -      | 加好友请求的 flag（需从上报的数据中获得） |
| approve | boolean  | `true` | 是否同意请求                              |
| remark  | string   | 空     | 添加后的好友备注（仅在同意时有效）        |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。

## 处理加群请求／邀请 <Badge text="未实现" type="danger" />

该接口用于处理加群请求／邀请。

### API 端点

`/set_group_add_request`

### 参数

| 字段名           | 数据类型 | 默认值 | 说明                                                                  |
| ---------------- | -------- | ------ | --------------------------------------------------------------------- |
| flag             | string   | -      | 加群请求的 flag（需从上报的数据中获得）                               |
| sub_type 或 type | string   | -      | `add` 或 `invite`, 请求类型（需要和上报消息中的 `sub_type` 字段相符） |
| approve          | boolean  | `true` | 是否同意请求／邀请                                                    |
| reason           | string   | 空     | 拒绝理由（仅在拒绝时有效）                                            |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。
