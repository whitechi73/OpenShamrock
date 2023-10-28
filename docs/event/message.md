---
title: 消息事件
icon: comment
---

::: tip 提示
所有上报事件都包含通用数据，详见 [通用数据](../general-data.md)。  
包含在通用数据中的字段不会在下面的表格中重复出现。
:::

## 消息事件

| 字段         | 类型   | 说明          |
| ------------ | ------ | ------------- |
| message_type | string | 消息类型      |
| sub_type     | string | 消息子类型    |
| message_id   | int64  | 消息 ID       |
| user_id      | int64  | 发送者 QQ 号  |
| message      | object | 消息内容      |
| raw_message  | string | CQ 码格式消息 |
| font         | int32  | 字体          |
| sender       | object | 发送人信息    |
| group_id     | int64                     | 群号       |
| target_id     | int64                     | 消息目标（私聊）       |
| peer_id      | int64                     | 消息接收者，群聊是群号，私聊时是目标QQ       |

## 私聊消息

当 `message_type` 为 `private` 时，表示收到了私聊消息。

## 群消息

当 `message_type` 为 `group` 时，表示收到了群消息。

## 快速回复

Shamrock 提供了快速回复的功能，可以在收到消息时快速回复消息。

| 字段        | 类型   | 说明         |
| ----------- | ------ | ------------ |
| reply       | string | 回复内容     |
| auto_escape | bool   | 是否自动转义 |
| auto_reply | bool | 是否自动回复到消息 |

## 快速操作

Shamrock 提供了快速操作的功能，可以在收到消息时快速执行操作。

| 字段         | 类型   | 说明           |
| ------------ | ------ | -------------- |
| reply        | string | 回复内容       |
| auto_escape  | bool   | 是否自动转义   |
| at_sender    | bool   | 是否 @发送者   |
| delete       | bool   | 是否撤回消息   |
| kick         | bool   | 是否踢出发送者 |
| ban          | bool   | 是否禁言发送者 |
| ban_duration | int64  | 禁言时长(秒)   |
