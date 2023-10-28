---
title: Shamrock 接口
icon: feather-alt
---

## 下载文件到缓存目录

### API 端点

`/download_file`

### 参数

| 字段   | 类型    | 必须 | 说明                 | 默认值 |
| ------ | ------- | ---- | -------------------- | ------ |
| url  | string | 是   | 下载地址             |        |
| thread_cnt | int32  | 否   | 下载的线程数量 |   |
| headers | `string` or `array` | 否 | 请求头 | |

#### 字符串格式示例

```string
User-Agent=YOUR_UA[\r\n]Referer=https://www.baidu.com
```

#### JSON数组

```json
[
    "User-Agent=YOUR_UA",
    "Referer=https://www.baidu.com"
]
```

> `[\r\n]` 为换行符, 使用http请求时请注意编码

### 响应

```json
{
  "file": "/scard/Android/data/com.tencent.mobileqq/Tencent/Shamrock/xxxx"
}
```

> 通过这个API下载的文件能直接放入CQ码作为图片发送
>
> 调用后会阻塞直到下载完成后才会返回数据，请注意下载大文件时的超时

## 获取手机电池信息

### API 端点

`/get_device_battery`

### 响应

```json
{
  "battery": 44,
  "scale": 3102000,
  "status": 2
}
```

## 获取Shamerock启动时间

### API 端点

`/get_start_time`

### 请求类型

`POST` | `GET` | `不支持WS`

### 响应

```json
{
  "status": "ok",
  "retcode": 0,
  "data": 1696749716155
}
```

## 获取Shamrock日志

### API 端点

`/log`

### 请求类型

`POST` | `GET` | `不支持WS`

### 参数

| 字段   | 类型    | 必须 | 说明                 | 默认值 |
| ------ | ------- | ---- | -------------------- | ------ |
| start  | int32 | 否   | 开始的行             |        |
| recent | bool  | 否   | 是否只显示最近的日志 | false  |

### 响应

```json
{
  "status": "ok",
  "retcode": 0,
  "data": 1696749716155
}
```

## 关闭Shamrock

### API 端点

`/shut`

### 请求类型

`POST` | `GET` | `不支持WS`

### 响应

无响应
