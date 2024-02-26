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

## 上传文件到缓存目录 （HTTP）

### API 端点

`/upload_file`

::: warning 注意
该接口仅仅为HTTP POST提供，WebSocket请使用另外一个。
:::

### 参数

以**file**格式上传文件，不要使用**binary**。

### 响应

```json
{
  "file": "/scard/Android/data/com.tencent.mobileqq/Tencent/Shamrock/xxxx"
}
```

## 上传文件到缓存目录 （WebSocket + HTTP）

### API 端点

`/upload_file_to_shamrock`

::: warning 注意
该接口仅仅为WebSocket提供。
:::

### 参数

| 名称 | 类型 | 作用 |
|------|-------|-------|
| md5 | string | 文件`hex格式`的md5值，32长度的字符串，整个文件的`md5` |
| offset | uint64 | 文件分段上传偏移，默认值为0，从头上传 |
| chunk | string | 文件分段上传数据块（base64），无需开头`base64://` |
| file_size | uint64 | 总文件大小 |  

### 响应数据

| 名称 | 类型 | 作用 |
|------|-------|-------|
| file_size | uint64 | 总文件大小 | 
| finish | bool | 是否完成上传 |
| path | string | 该文件在安卓系统（shamrock环境）的路径 |

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
| root       | string              | 否   | 保存文件的根目录，注意请确保QQ可以访问       | Shamrock缓存目录 |
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

## 清除缓存

### API 端点

`clean_cache`

### 参数

该接口没有参数

### 响应

```json
{
  "status": "ok",
  "retcode": 0
}
```

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

## 获取所有支持的动作

### API 端点

`/get_supported_actions`

### 响应

{
  "status": "ok",
  "retcode": 0,
  "data": [
    "set_group_ban",
    "clean_cache",
    "clear_msgs",
    "create_group_file_folder",
    "delete_essence_message",
    "delete_essence_msg",
    "delete_group_file",
    "delete_group_folder",
    "delete_msg",
    "delete_message",
    "download_file",
    "fav.add_image_msg",
    "fav.add_text_msg",
    "fav.get_item_content",
    "fav.get_item_list",
    "get_csrf_token",
    "get_cookie",
    "get_cookies",
    "get_credentials",
    "get_device_battery",
    "get_essence_message_list",
    "get_essence_msg_list",
    "get_forward_msg",
    "get_friend_list",
    "get_friend_system_msg",
    "get_group_file_system_info",
    "get_group_file_url",
    "get_group_msg_history",
    "get_group_notice",
    "_get_group_notice",
    "get_group_at_all_remain",
    "get_group_root_files",
    "get_group_files_by_folder",
    "get_group_system_msg",
    "get_guild_list",
    "get_guild_service_profile",
    "get_history_msg",
    "get_http_cookies",
    "get_image",
    "get_latest_events",
    "get_login_info",
    "get_model_show",
    "_get_model_show",
    "get_msg",
    "get_message",
    "get_not_joined_group_info",
    "_get_online_clients",
    "get_profile_card",
    "get_user_info",
    "get_prohibited_member_list",
    "get_record",
    "get_self_info",
    "status",
    "get_status",
    "_get_stranger_info",
    "get_stranger_info",
    "get_supported_actions",
    "get_troop_honor_info",
    "get_group_honor_info",
    "get_group_info",
    "get_group_list",
    "get_group_member_info",
    "get_group_member_list",
    "get_uid",
    "get_uin_by_uid",
    "get_version",
    "get_version_info",
    "get_weather",
    "get_weather_city_code",
    "poke",
    "is_blacklist_uin",
    "kick_group_member",
    "set_group_kick",
    "set_group_leave",
    "leave_group",
    "set_group_card",
    "set_group_name",
    ".handle_quick_operation_async",
    "rename_group_folder",
    "restart_me",
    "sanc_qrcode",
    "send_forward_msg",
    "send_group_forward_msg",
    "send_group_msg",
    "send_group_message",
    "send_group_announcement",
    "send_group_notice",
    "send_group_sign",
    "send_like",
    "send_message",
    "send_msg",
    "send_private_forward_msg",
    "send_private_message",
    "send_private_msg",
    "set_essence_message",
    "set_essence_msg",
    "set_friend_add_request",
    "set_group_add_request",
    "set_group_admin",
    "set_group_comment_face",
    "set_group_special_title",
    "set_group_whole_ban",
    "_set_model_show",
    "set_qq_profile",
    "switch_account",
    "test",
    "upload_group_file",
    "upload_private_file"
  ],
  "echo": ""
}