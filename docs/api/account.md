---
title: 账号相关
icon: user
---

::: warning 注意
对于 Shamrock 尚未实现的 API，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

## 获取登录号信息

该接口用于获取 QQ 用户的登录号信息。

### API 端点

`/get_login_info`

### 参数

::: tip 提示
该接口无输入参数。
:::

### 响应

::: tabs

@tab 响应字段

| 字段     | 类型   | 说明  |
| -------- | ------ | ----- |
| user_id  | int64  | QQ 号 |
| nickname | string | 昵称  |

@tab 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "user_id": 2854200454,
    "nickname": "Shamrock"
  }
}
```

:::

## 设置 QQ 个人资料

该接口用于设置 QQ 用户的个人资料信息。

### API 端点

`/set_qq_profile`

### 参数

| 字段          | 类型   | 必须 | 说明                     |
| ------------- | ------ | ---- | ------------------------ |
| nickname      | string | 是   | 昵称                     |
| company       | string | 是   | 公司                     |
| email         | string | 是   | 邮箱                     |
| college       | string | 是   | 大学                     |
| personal_note | string | 是   | 个人备注                 |
| age           | int32  | 否   | 年龄                     |
| birthday      | string | 否   | 生日（格式：YYYY-MM-DD） |

### 响应

该接口将返回基本的 json 。

## 获取在线机型

该接口用于获取 QQ 在线机型。

### API 端点

`/_get_model_show`

### 参数

::: tabs

@tab 参数字段

| 字段  | 类型   | 必须 | 说明 |
| ----- | ------ | ---- | ---- |
| model | string | 是   | 机型 |

@tab 参数示例

```json
{
  "model": "OPPO"
}
```

:::

### 响应

::: tabs

@tab 响应字段

| 字段     | 类型                              | 说明     |
| -------- | --------------------------------- | -------- |
| variants | List<[ModelDetail](#modeldetail)> | 机型列表 |

@tab 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "variants": [
      {
        "model_show": "OPPO (黑色)",
        "need_pay": true
      },
      {
        "model_show": "OPPO (白色)",
        "need_pay": true
      },
      {
        "model_show": "OPPO (银色)",
        "need_pay": true
      },
      {
        "model_show": "OPPO (灰色)",
        "need_pay": true
      },
      {
        "model_show": "OPPO (金色)",
        "need_pay": true
      },
      {
        "model_show": "OPPO",
        "need_pay": false
      }
    ]
  }
}
```

:::

#### ModelDetail

| 字段       | 类型   | 说明         |
| ---------- | ------ | ------------ |
| model_show | string | 机型名称     |
| need_pay   | bool   | 是否需要付费 |

## 设置在线机型

该接口用于设置 QQ 在线机型。

### API 端点

`/_set_model_show`

### 参数

| 字段  | 类型   | 必须 | 说明 |
| ----- | ------ | ---- | ---- |
| model | string | 是   | 机型 |
| manu  | string | 是   | 厂商 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。

## 获取当前账号在线客户端列表 <Badge text="未实现" type="danger" />

该接口用于获取当前账号在线客户端列表。

### API 端点

`/get_online_clients`

### 参数

| 字段     | 类型 | 说明         |
| -------- | ---- | ------------ |
| no_cache | bool | 是否无视缓存 |

### 响应

| 字段    | 类型                      | 说明           |
| ------- | ------------------------- | -------------- |
| clients | Object<[Device](#device)> | 在线客户端列表 |

#### Device

| 字段        | 类型   | 说明     |
| ----------- | ------ | -------- |
| app_id      | int64  | 客户端ID |
| device_name | string | 设备名称 |
| device_kind | string | 设备类型 |
