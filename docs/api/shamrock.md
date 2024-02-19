---
title: Shamrock 接口
icon: feather-alt
---

## 切换账号

某个账号因为某种原因寄了，允许切换备用能源！

### API端点

`/switch_account`

## 参数

| 字段    | 类型  | 必须 | 说明 | 默认值 |
| ------- | ----- | ---- | ---- | ------ |
| user_id | int64 | 是   | QQ   |        |

### 响应

是否正常执行切换账号请求的响应。

## 上传文件到缓存目录

### API 端点

`/upload_file`

### 参数

以**file**格式上传文件，不要使用**binary**。

### 响应

```json
{
  "file": "/scard/Android/data/com.tencent.mobileqq/Tencent/Shamrock/xxxx"
}
```

## 让Shamrock下载文件到缓存目录

用法二选一：

1.仅发送url，由Shamrock自己访问该url来下载文件

2.仅发送文件base64，Shamrock解码后直接转存为文件

url和base64至少一个不能为空

同时发送url和base64时，使用url

### API 端点

`/download_file`

### 参数

| 字段       | 类型                | 必须 | 说明           | 默认值  |
| ---------- | ------------------- | ---- | -------------- | ------- |
| url        | string              | 否   | 下载地址       |         |
| name       | string              | 否   | 文件名称       | 文件md5 |
| base64     | string              | 否   | 文件base64内容 |         |
| thread_cnt | int32               | 否   | 下载的线程数量 |         |
| headers    | `string` or `array` | 否   | 请求头         |         |

#### headers为string时示例

```json
"headers": "User-Agent=YOUR_UA[\r\n]Referer=https://www.baidu.com"
```

#### headers为array时示例

```json
"headers": [
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

| 字段   | 类型  | 必须 | 说明                 | 默认值 |
| ------ | ----- | ---- | -------------------- | ------ |
| start  | int32 | 否   | 开始的行             |        |
| recent | bool  | 否   | 是否只显示最近的日志 | false  |

## 远程Shell执行

该接口默认关闭，需要在实验室设置手动打开！注意，该接口可能导致您的隐私数据泄露，请勿公开在未知的网络，或者泄露您的token。

### 请求类型

`POST`

### 参数

| 字段 | 类型            | 必须 | 说明           | 默认值 |
| ---- | --------------- | ---- | -------------- | ------ |
| cmd  | array 或 string | 是   | 命令内容       |        |
| dir  | string          | 是   | 当前所处的目录 |        |

## 关闭Shamrock

### API 端点

`/shut`

### 请求类型

`POST` | `GET` | `不支持WS`

### 响应

无响应
