---
title: 通用数据
icon: database
---

## 所有上报

所有上报事件都包含以下字段：

| 字段      | 类型   | 说明     |
| --------- | ------ | -------- |
| time      | int64  | 时间戳   |
| self_id   | int64  | 机器人QQ |
| post_type | string | 上报类型 |

::: tip 提示
`post_type` 为 `message` 或 `message_sent` 时，数据是一致的。  
区别在于 `message` 是收到的消息，`message_sent` 是发送的消息。

默认情况下，Shamrock 只会上报 `message` 类型的消息。  
并且 Shamrock 暂未实现 `message_sent` 类型的上报。
:::

## 事件类型

### PostType

| 类型             | 说明     |
| ---------------- | -------- |
| message          | 收到消息 |
| ~~message_sent~~ | 发送消息 |
| notice           | 通知     |
| ~~request~~      | 请求     |

### MessageType

| 类型    | 说明     |
| ------- | -------- |
| private | 私聊消息 |
| group   | 群消息   |

### MessageSubType

| 类型          | 说明             |
| ------------- | ---------------- |
| friend        | 好友消息         |
| normal        | 群消息           |
| ~~anonymous~~ | 匿名消息         |
| group         | 群临时消息       |
| group_self    | 群消息(自身操作) |
| notice        | 系统提示         |

### NoticeType

| 类型           | 说明             |
| -------------- | ---------------- |
| group_upload   | 群文件上传       |
| group_admin    | 群管理员变动     |
| group_decrease | 群成员减少       |
| group_increase | 群成员增加       |
| group_ban      | 群禁言           |
| group_recall   | 群消息撤回       |
| group_card     | 群成员名片变动   |
| friend_add     | 好友添加         |
| friend_recall  | 好友撤回         |
| offline_file   | 接收到离线文件包 |
| client_status  | 客户端状态       |
| essence        | 精华消息         |
| notify         | 系统通知         |

### NoticeNotifySubType

| 类型       | 说明       |
| ---------- | ---------- |
| honor      | 群荣誉变更 |
| poke       | 戳一戳     |
| lucky_king | 运气王     |
| title      | 群头衔变更 |

### RequestType

| 类型   | 说明     |
| ------ | -------- |
| friend | 好友请求 |
| group  | 群请求   |

## 数据结构

### MessageSender

| 字段     | 类型   | 说明         |
| -------- | ------ | ------------ |
| user_id  | int64  | 发送者 QQ 号 |
| nickname | string | 发送者昵称   |

如果是群消息，还会包含以下字段：

| 字段  | 类型   | 说明         |
| ----- | ------ | ------------ |
| card  | string | 发送者群名片 |
| level | string | 发送者等级   |
| role  | string | 发送者角色   |
| title | string | 发送者头衔   |
