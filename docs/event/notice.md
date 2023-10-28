---
title: 通知事件
icon: bell
---

::: warning 注意
对于 Shamrock 未实现的事件，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

::: tip 提示
所有上报事件都包含通用数据，详见 [通用数据](../general-data.md)。  
包含在通用数据中的字段不会在下面的表格中重复出现。
:::

## 私聊消息撤回

当 `notice_type` 为 `private_recall` 时，表示收到了私聊消息撤回事件。

| 字段        | 类型  | 说明         |
| ----------- | ----- | ------------ |
| user_id     | int64 | 好友 QQ 号   |
| operator_id | int64 | 操作者 QQ 号 |
| message_id  | int64 | 消息 ID      |

## 群聊消息撤回

当 `notice_type` 为 `group_recall` 时，表示收到了群聊消息撤回事件。

| 字段        | 类型  | 说明         |
| ----------- | ----- | ------------ |
| group_id    | int64 | 群号         |
| user_id     | int64 | 发送者 QQ 号 |
| operator_id | int64 | 操作者 QQ 号 |
| message_id  | int64 | 消息 ID      |

## 群组成员增加

当 `notice_type` 为 `group_increase` 时，表示收到了群组成员增加事件。

| 字段        | 类型   | 说明                   |
| ----------- | ------ | ---------------------- |
| group_id    | int64  | 群号                   |
| user_id     | int64  | 新增成员 QQ            |
| operator_id | int64  | 操作者 QQ 号           |
| sub_type    | string | 子类型(approve/invite) |

## 群组成员减少

当 `notice_type` 为 `group_decrease` 时，表示收到了群组成员减少事件。

| 字段        | 类型   | 说明                       |
| ----------- | ------ | -------------------------- |
| group_id    | int64  | 群号                       |
| user_id     | int64  | 减少成员 QQ                |
| operator_id | int64  | 操作者 QQ 号               |
| sub_type    | string | 子类型(leave/kick/kick_me) |

## 群组管理员变动

当 `notice_type` 为 `group_admin` 时，表示收到了群组管理员变动事件。

| 字段     | 类型   | 说明              |
| -------- | ------ | ----------------- |
| group_id | int64  | 群号              |
| user_id  | int64  | 变动成员 QQ       |
| sub_type | string | 子类型(set/unset) |

## 群文件上传

当 `notice_type` 为 `group_upload` 时，表示收到了群文件上传事件。

| 字段     | 类型   | 说明      |
| -------- | ------ | --------- |
| group_id | int64  | 群号      |
| user_id  | int64  | 上传者 QQ |
| file     | object | 群文件信息  |

### 群文件信息结构体

| 字段名 | 数据类型 | 说明 |
| ------- | ------- | ---- |
| id | string | 文件 ID |
| name | string | 文件名 |
| size | int64 | 文件大小 ( 字节数 ) |
| busid | int64 | busid ( 目前不清楚有什么作用 ) |
| url | string | 下载地址 |

## 私聊文件上传

当 `notice_type` 为 `private_upload` 时，表示收到了群文件上传事件。

| 字段     | 类型   | 说明      |
| -------- | ------ | --------- |
| user_id  | int64  | 上传者 QQ |
| sender  | int64  | 上传者 QQ |
| private_file     | object | 私聊文件信息  |

### 私聊文件信息结构体

| 字段名 | 数据类型 | 说明 |
| ------- | ------- | ---- |
| id | string | 文件 ID |
| name | string | 文件名 |
| size | int64 | 文件大小 ( 字节数 ) |
| url | string | 下载地址 |
| sub_id | string | 子文件ID |
| exppire | int64 | 文件过期时间 |

## 群禁言

当 `notice_type` 为 `group_ban` 时，表示收到了群禁言事件。

| 字段        | 类型   | 说明                 |
| ----------- | ------ | -------------------- |
| group_id    | int64  | 群号                 |
| user_id     | int64  | 操作者 QQ            |
| operator_id | int64  | 被禁言成员 QQ        |
| duration    | int64  | 禁言时长(秒)         |
| sub_type    | string | 子类型(ban/lift_ban) |

## 群成员名片变动 <Badge text="未实现" type="danger" />

当 `notice_type` 为 `group_card` 时，表示收到了群成员名片变动事件。

| 字段     | 类型   | 说明        |
| -------- | ------ | ----------- |
| group_id | int64  | 群号        |
| user_id  | int64  | 变动成员 QQ |
| card_new | string | 新名片      |
| card_old | string | 旧名片      |

## 好友添加 <Badge text="未实现" type="danger" />

当 `notice_type` 为 `friend_add` 时，表示收到了好友添加事件。

| 字段    | 类型  | 说明             |
| ------- | ----- | ---------------- |
| user_id | int64 | 新添加好友 QQ 号 |

## 收到离线文件 <Badge text="未实现" type="danger" />

当 `notice_type` 为 `offline_file` 时，表示收到了离线文件事件。

| 字段    | 类型   | 说明      |
| ------- | ------ | --------- |
| user_id | int64  | 发送者 QQ |
| file    | object | 文件信息  |

### 文件信息

| 字段 | 类型   | 说明     |
| ---- | ------ | -------- |
| name | string | 文件名   |
| size | int64  | 文件大小 |
| url  | string | 下载链接 |

## 精华消息 <Badge text="未实现" type="danger" />

当 `notice_type` 为 `essence` 时，表示收到了精华消息事件。

| 字段        | 类型   | 说明               |
| ----------- | ------ | ------------------ |
| group_id    | int64  | 群号               |
| sender_id   | int64  | 发送者 QQ          |
| operator_id | int64  | 操作者 QQ          |
| message_id  | int64  | 消息 ID            |
| sub_type    | string | 子类型(add/delete) |

## 客户端状态 <Badge text="未实现" type="danger" />

当 `notice_type` 为 `client_status` 时，表示收到了客户端状态事件。

| 字段   | 类型   | 说明       |
| ------ | ------ | ---------- |
| client | object | 客户端信息 |
| online | bool   | 在线状态   |

## 头像戳一戳

当 `notice_type` 为 `notify` 且 `sub_type` 为 `poke` 时，表示收到了头像戳一戳事件。

| 字段      | 类型  | 说明             |
| --------- | ----- | ---------------- |
| user_id   | int64 | 发送者 QQ        |
| sender_id | int64 | 好友 QQ (仅私聊) |
| group_id  | int64 | 群号(仅群聊)     |
| target_id | int64 | 被戳者 QQ        |

## 群红包运气王 <Badge text="未实现" type="danger" />

当 `notice_type` 为 `notify` 且 `sub_type` 为 `lucky_king` 时，表示收到了群红包运气王事件。

| 字段      | 类型  | 说明   |
| --------- | ----- | ------ |
| group_id  | int64 | 群号   |
| user_id   | int64 | 发送者 |
| target_id | int64 | 运气王 |

## 群荣誉变更 <Badge text="未实现" type="danger" />

当 `notice_type` 为 `notify` 且 `sub_type` 为 `honor` 时，表示收到了群荣誉变更事件。

| 字段       | 类型   | 说明     |
| ---------- | ------ | -------- |
| group_id   | int64  | 群号     |
| user_id    | int64  | 操作者   |
| honor_type | string | 荣誉类型 |

## 群头衔变更 <Badge text="未实现" type="danger" />

当 `notice_type` 为 `notify` 且 `sub_type` 为 `title` 时，表示收到了群头衔变更事件。

| 字段     | 类型   | 说明     |
| -------- | ------ | -------- |
| group_id | int64  | 群号     |
| user_id  | int64  | 操作者   |
| title    | string | 获得头衔 |
