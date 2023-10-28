---
title: 群聊相关
icon: user-group
---

::: warning 注意
对于 Shamrock 尚未实现的 API，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

## 设置群名

该接口用于设置群名。

### API 端点

`/set_group_name`

### 参数

| 字段名     | 数据类型 | 说明   |
| ---------- | -------- | ------ |
| group_id   | int64    | 群号   |
| group_name | string   | 新群名 |

::: tip 提示
该 API 无响应数据
:::

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。

## 设置群头像 <Badge text="未实现" type="danger" />

该接口用于设置群头像。

### API 端点

`/set_group_portrait`

### 参数

| 字段     | 类型   | 说明                     |
| -------- | ------ | ------------------------ |
| group_id | int64  | 群号                     |
| file     | string | 图片文件名               |
| cache    | int    | 表示是否使用已缓存的文件 |

[1] `file` **参数**支持以下几种格式：

- 绝对路径, 例如 `file:///C:\\Users\Richard\Pictures\1.png`, 格式使用 [`file` URI](https://tools.ietf.org/html/rfc8089)
- 网络 URL, 例如 `http://i1.piimg.com/567571/fdd6e7b6d93f1ef0.jpg`
- Base64 编码, 例如 `base64://iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAIAAADJt1n/AAAAKElEQVQ4EWPk5+RmIBcwkasRpG9UM4mhNxpgowFGMARGEwnBIEJVAAAdBgBNAZf+QAAAAABJRU5ErkJggg==`

[2] `cache`**参数**: 通过网络 URL 发送时有效, `1`表示使用缓存, `0`关闭关闭缓存, 默认 为`1`

## 设置群管理员

该接口用于设置群管理员。

### API 端点

`/set_group_admin`

### 参数

| 字段     | 类型  | 必须 | 说明     |
| -------- | ----- | ---- | -------- |
| group_id | int64 | 是   | 群号     |
| user_id  | int64 | 是   | QQ 号    |
| enable   | bool  | 是   | 是否设置 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。

## 设置群备注 <Badge text="未实现" type="danger" />

该接口用于设置群备注。

### API 端点

`/set_group_card`

### 参数

| 字段名   | 数据类型 | 默认值 | 说明                                     |
| -------- | -------- | ------ | ---------------------------------------- |
| group_id | int64    | -      | 群号                                     |
| user_id  | int64    | -      | 要设置的 QQ 号                           |
| card     | string   | 空     | 群名片内容, 不填或空字符串表示删除群名片 |

::: tip 提示
该 API 无响应数据
:::

## 设置群组专属头衔

该接口用于设置群组专属头衔。

### API 端点

`/set_group_special_title`

### 参数

| 字段          | 类型   | 必须 | 说明  |
| ------------- | ------ | ---- | ----- |
| group_id      | int64  | 是   | 群号  |
| user_id       | int64  | 是   | QQ 号 |
| special_title | string | 是   | 头衔  |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。

## 群单人禁言

该接口用于群单人禁言。

### API 端点

`/set_group_ban`

### 参数

::: tip 提示
当 `duration` 为 `0` 时，将解除禁言。
:::

| 字段     | 类型  | 必须 | 说明     |
| -------- | ----- | ---- | -------- |
| group_id | int64 | 是   | 群号     |
| user_id  | int64 | 是   | QQ 号    |
| duration | int64 | 是   | 禁言时长 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。

## 群全员禁言

该接口用于群全员禁言。

### API 端点

`/set_group_whole_ban`

### 参数

| 字段名   | 数据类型 | 默认值 | 说明     |
| -------- | -------- | ------ | -------- |
| group_id | int64    | -      | 群号     |
| enable   | boolean  | `true` | 是否禁言 |

::: tip 提示
该 API 无响应数据
:::

### API 端点

`/set_group_whole_ban`

### 参数

| 字段     | 类型  | 必须 | 说明     |
| -------- | ----- | ---- | -------- |
| group_id | int64 | 是   | 群号     |
| enable   | bool  | 是   | 是否禁言 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。

## 设置精华消息 <Badge text="未实现" type="danger" />

该接口用于设置精华消息。

### API 端点

`/set_essence_msg`

### 参数

| 字段       | 类型  | 说明   |
| ---------- | ----- | ------ |
| message_id | int32 | 消息ID |

::: tip 提示
该 API 没有响应数据
:::

## 移出精华消息 <Badge text="未实现" type="danger" />

该接口用于移出精华消息。

### API 端点

`/delete_essence_msg`

### 参数

| 字段       | 类型  | 说明   |
| ---------- | ----- | ------ |
| message_id | int32 | 消息ID |

::: tip 提示
该 API 没有响应数据
:::

## 群打卡 <Badge text="未实现" type="danger" />

该接口用于群打卡。

### API 端点

`/send_group_sign`

### 参数

| 字段名   | 数据类型 | 说明 |
| -------- | -------- | ---- |
| group_id | int64    | 群号 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。

## 发送群公告 <Badge text="未实现" type="danger" />

该接口用于发送群公告。

### API 端点

`/_send_group_notice`

### 参数

| 字段名   | 数据类型 | 默认值 | 说明             |
| -------- | -------- | ------ | ---------------- |
| group_id | int64    |        | 群号             |
| content  | string   |        | 公告内容         |
| image`   | string   |        | 图片路径（可选） |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。

## 获取群公告 <Badge text="未实现" type="danger" />

该接口用于获取群公告。

### API 端点

`/_get_group_notice`

### 参数

| 字段名   | 数据类型 | 默认值 | 说明 |
| -------- | -------- | ------ | ---- |
| group_id | int64    |        | 群号 |

### 响应数据

data 的响应内容为 json 数组，每个元素内容如下：

| 字段         | 类型                        | 说明         |
| ------------ | --------------------------- | ------------ |
| sender_id    | int64                       | 公告发表者   |
| publish_time | int64                       | 公告发表时间 |
| message      | Object<[Message](#message)> | 公告内容     |

#### message

| 字段   | 类型                    | 说明     |
| ------ | ----------------------- | -------- |
| text   | string                  | 公告内容 |
| images | List<[Images](#images)> | 公告图片 |

#### images

| 字段   | 类型   | 说明     |
| ------ | ------ | -------- |
| height | string | 图片高度 |
| width  | string | 图片宽度 |
| id     | string | 图片ID   |

## 群组踢人

该接口用于群组踢人。

### API 端点

`/set_group_kick`

### 参数

| 字段               | 类型  | 必须 | 说明             |
| ------------------ | ----- | ---- | ---------------- |
| group_id           | int64 | 是   | 群号             |
| user_id            | int64 | 是   | QQ 号            |
| reject_add_request | bool  | 否   | 是否拒绝再次加群 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。

## 退出群组

该接口用于退出群组。

### API 端点

`/set_group_leave`

### 参数

| 字段     | 类型  | 必须 | 说明 |
| -------- | ----- | ---- | ---- |
| group_id | int64 | 是   | 群号 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。

## 群戳一戳

该接口用于群戳一戳。

### API 端点

`/group_touch`

### 参数

| 字段     | 类型  | 必须 | 说明  |
| -------- | ----- | ---- | ----- |
| group_id | int64 | 是   | 群号  |
| user_id  | int64 | 是   | QQ 号 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。
