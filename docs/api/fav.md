---
title: QQ收藏 接口
icon: feather-alt
---

::: warning 注意
这里的API处于实验性阶段，不会进行大量维护和更新，由于过于简单，如果需要某些功能可以自行PR！
:::


## 获取收藏列表

获取收藏列表

### API端点

`/fav/get_item_list` (HTTP)

`fav.get_item_list` (WebSocket)

## 参数

| 字段   | 类型    | 必须 | 说明                 | 默认值 |
| ------ | ------- | ---- | -------------------- | ------ |
| page_size  | int32 | 是   | 获取的数量             |        |
| category  | int32 | 是   | 分类             |        |
| start_pos  | int32 | 是   | 开始的位置             |        |

### 响应

```json 
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "items": [
      {
        "id": "1-1-9dec6664-dcb7-4b46-986f-xxxxxx",
        "author_type": 2,
        "author": 2806922524,
        "author_name": "2806922524",
        "group_name": "ˢʰᵃᵐʳᵒᶜᵏ",
        "group_id": 333425833,
        "client_version": "8.9.12820",
        "time": 1703004793000
      }
    ]
  },
  "echo": ""
}
```

## 获取指定收藏的内容

获取收藏内容

### API端点

`/fav/get_item_content` (HTTP)

`fav.get_item_content` (WebSocket)

## 参数

| 字段   | 类型    | 必须 | 说明                 | 默认值 |
| ------ | ------- | ---- | -------------------- | ------ |
| id  | string | 是   | id             |        |

### 响应

```json 
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "content": "在想可不可以在手机上跑bot（）"
  },
  "echo": ""
}
```

## 添加文本收藏

添加一段文字到QQ收藏

### API端点

`/fav/add_text_msg` (HTTP)

`fav.add_text_msg` (WebSocket)

## 参数

| 字段   | 类型    | 必须 | 说明                 | 默认值 |
| ------ | ------- | ---- | -------------------- | ------ |
| content  | string | 是   | 内容             |        |

### 响应

```json 
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "id": "xxxxxxxx"
  },
  "echo": ""
}
```

## 添加图片收藏

添加一个图片到QQ收藏

### API端点

`/fav/add_image_msg` (HTTP)

`fav.add_image_msg` (WebSocket)

## 参数

| 字段   | 类型    | 必须 | 说明                 | 默认值 |
| ------ | ------- | ---- | -------------------- | ------ |
| file  | string | 是   | 图片base64或者绝对路径或者URL             |        |

### 响应

```json 
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "id": "xxxxxxxx"
  },
  "echo": ""
}
```