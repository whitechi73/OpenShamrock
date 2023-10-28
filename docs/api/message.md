---
title: 消息相关
icon: comment
---

::: warning 注意
对于 Shamrock 尚未实现的 API，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

## 发送私聊消息

该接口用于发送私聊消息。

### API 端点

`/send_private_msg`

### 参数

| 字段        | 类型   | 必须 | 说明             |
| ----------- | ------ | ---- | ---------------- |
| user_id     | int64  | 是   | QQ 号            |
| message     | string | 是   | 消息内容         |
| auto_escape | bool   | 否   | 是否解析 CQ 码。 |

### 响应

| 字段       | 类型  | 说明    |
| ---------- | ----- | ------- |
| message_id | int32 | 消息 ID |
| time       | int64 | 时间戳  |

## 发送群聊消息

该接口用于发送群聊消息。

### API 端点

`/send_group_msg`

### 参数

| 字段        | 类型   | 必须 | 说明             |
| ----------- | ------ | ---- | ---------------- |
| group_id    | int64  | 是   | 群号             |
| message     | string | 是   | 消息内容         |
| auto_escape | bool   | 否   | 是否解析 CQ 码。 |

### 响应

| 字段       | 类型  | 说明    |
| ---------- | ----- | ------- |
| message_id | int32 | 消息 ID |
| time       | int64 | 时间戳  |

## 发送消息

该接口用于发送消息。

### API 端点

`/send_msg`

### 参数

| 字段         | 类型   | 必须 | 说明             |
| ------------ | ------ | ---- | ---------------- |
| message_type | string | 是   | 消息类型         |
| user_id      | int64  | 是   | QQ 号            |
| group_id     | int64  | 是   | 群号             |
| discuss_id   | int64  | 是   | 讨论组号         |
| message      | string | 是   | 消息内容         |
| auto_escape  | bool   | 否   | 是否解析 CQ 码。 |

::: warning 注意
当前发送消息的 API 暂不支持发送讨论组消息。
:::

### 响应

| 字段       | 类型  | 说明    |
| ---------- | ----- | ------- |
| message_id | int32 | 消息 ID |
| time       | int64 | 时间戳  |

## 获取消息

### API 端点

`/get_msg`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| message_id | int32 | 是   | 消息 ID |

### 响应

| 字段         | 类型                      | 说明       |
| ------------ | ------------------------- | ---------- |
| time         | int64                     | 时间戳     |
| message_type | string                    | 消息类型   |
| message_id   | int32                     | 消息 ID    |
| real_id      | int32                     | 真实 ID    |
| sender       | Object<[Sender](#sender)> | 发送人信息 |
| message      | object                    | 消息体     |
| group_id     | int64                     | 群号       |
| target_id     | int64                     | 消息目标（私聊）       |
| peer_id      | int64                     | 消息接收者，群聊是群号，私聊时是目标QQ       |

> `peer_id`是其他同类框架所表达的`target_id`!

#### Sender

| 字段     | 类型   | 说明  |
| -------- | ------ | ----- |
| user_id  | int64  | QQ 号 |
| nickname | string | 昵称  |
| sex      | string | 性别  |
| age      | int32  | 年龄  |
| uid      | string | UID   |

## 撤回消息

该接口用于撤回消息。

### API 端点

`/delete_msg`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| message_id | int32 | 是   | 消息 ID |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。
