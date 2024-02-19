---
title: 常规消息
icon: comment-dots
---

## AT 某人

### 参数

::: tip 提示
当 `qq` 字段为 `"0"`或`"all"` 时, 表示 AT 全体成员。
:::

| 字段 | 类型   | 收  | 发  | 必填 | 说明  |
| ---- | ------ | --- | --- | ---- | ----- |
| qq   | string | ✓   | ✓   | 否   | QQ 号 |

::: warning 注意
将在未来实现 `qq` 字段为 `online` 和 `admin` 时的功能。
:::

::: tabs

@tab CQ 码

```text
[CQ:at,qq=123456]
```

@tab 消息段

```json
{
  "type": "at",
  "data": {
    "qq": "123456"
  }
}
```

:::

## 表情

### 参数

| 字段 | 类型 | 收  | 发  | 必填 | 说明         |
| ---- | ---- | --- | --- | ---- | ------------ |
| id   | int  | ✓   | ✓   | 是   | 表情 ID      |
| big  | bool | ✓   | X   | 否   | 是否是大表情 |

::: tip 提示
表情 ID 可以在 [这里](https://github.com/richardchien/coolq-http-api/wiki/%E8%A1%A8%E6%83%85-CQ-%E7%A0%81-ID-%E8%A1%A8) 查看。
:::

::: tabs

@tab CQ 码

```text
[CQ:face,id=351,big=true]
```

@tab 消息段

```json
{
  "type": "face",
  "data": {
    "id": 351,
    "big": true
  }
}
```

:::

## 弹射表情

### 参数

| 字段  | 类型 | 收  | 发  | 必填 | 说明    |
| ----- | ---- | --- | --- | ---- | ------- |
| id    | int  | ✓   | ✓   | 是   | 表情 ID |
| count | int  | ✓   | √   | 是   | 数量    |

::: tip 提示
表情 ID 可以在 [这里](https://github.com/richardchien/coolq-http-api/wiki/%E8%A1%A8%E6%83%85-CQ-%E7%A0%81-ID-%E8%A1%A8) 查看。
:::

::: tabs

@tab CQ 码

```text
[CQ:bubble_face,id=351,count=114514]
```

@tab 消息段

```json
{
  "type": "bubble_face",
  "data": {
    "id": 351,
    "count": 114514
  }
}
```

:::

## 回复

### 参数

| 字段 | 类型 | 收  | 发  | 必填 | 说明    |
| ---- | ---- | --- | --- | ---- | ------- |
| id   | int  | ✓   | ✓   | 是   | 消息 ID |

:::tabs

@tab CQ 码

```text
[CQ:reply,id=1]
```

@tab 消息段

```json
{
  "type": "reply",
  "data": {
    "id": 1
  }
}
```

:::
