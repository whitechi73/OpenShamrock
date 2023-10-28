---
title: 请求事件
icon: bullhorn
---

::: warning 注意
对于 Shamrock 未实现的事件，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

::: tip 提示
所有上报事件都包含通用数据，详见 [通用数据](../general-data.md)。  
包含在通用数据中的字段不会在下面的表格中重复出现。
:::

## 加好友请求 <Badge text="未实现" type="danger" />

当 `request_type` 为 `friend` 时，表示收到了加好友请求。

| 字段    | 类型   | 说明         |
| ------- | ------ | ------------ |
| user_id | int64  | 请求者 QQ 号 |
| comment | string | 验证信息     |
| flag    | string | 请求 flag    |

### 快速处理

Shamrock 提供了快速处理的功能，可以在收到请求时快速处理请求。

| 字段    | 类型   | 说明     |
| ------- | ------ | -------- |
| approve | bool   | 是否同意 |
| remark  | string | 备注     |

## 加群请求／邀请 <Badge text="未实现" type="danger" />

当 `request_type` 为 `group` 时，表示收到了加群请求／邀请。

| 字段     | 类型   | 说明               |
| -------- | ------ | ------------------ |
| group_id | int64  | 群号               |
| user_id  | int64  | 请求者 QQ 号       |
| comment  | string | 验证信息           |
| flag     | string | 请求 flag          |
| sub_type | string | 子类型(add/invite) |

### 快速处理

Shamrock 提供了快速处理的功能，可以在收到请求时快速处理请求。

| 字段    | 类型   | 说明     |
| ------- | ------ | -------- |
| approve | bool   | 是否同意 |
| reason  | string | 拒绝理由 |
