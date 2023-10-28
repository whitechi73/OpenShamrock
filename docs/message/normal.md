---
title: 常规消息
icon: comment-dots
---

## AT 某人

### 参数

::: tip 提示
当 `qq` 字段为 `all` 时, 表示 AT 全体成员。
:::

| 字段 | 类型 | 收  | 发  | 必填 | 说明  |
| ---- | ---- | --- | --- | ---- | ----- |
| qq   | int  | ✓   | ✓   | 否   | QQ 号 |

::: warning 注意
将在未来实现 `qq` 字段为 `online` 和 `admin` 时的功能。
:::

### CQ 码

```
[CQ:at,qq=123456]
```

### 消息段

```json
{
  "type": "at",
  "data": {
    "qq": 123456
  }
}
```

## 表情

### 参数

| 字段 | 类型 | 收  | 发  | 必填 | 说明    |
| ---- | ---- | --- | --- | ---- | ------- |
| id   | int  | ✓   | ✓   | 是   | 表情 ID |

::: tip 提示
表情 ID 可以在 [这里](https://github.com/richardchien/coolq-http-api/wiki/%E8%A1%A8%E6%83%85-CQ-%E7%A0%81-ID-%E8%A1%A8) 查看。
:::

### CQ 码

```
[CQ:face,id=1]
```

### 消息段

```json
{
  "type": "face",
  "data": {
    "id": 1
  }
}
```

## 回复

### 参数

| 字段 | 类型 | 收  | 发  | 必填 | 说明    |
| ---- | ---- | --- | --- | ---- | ------- |
| id   | int  | ✓   | ✓   | 是   | 消息 ID |

### CQ 码

```
[CQ:reply,id=1]
```

### 消息段

```json
{
  "type": "reply",
  "data": {
    "id": 1
  }
}
```
