---
title: 文件相关
icon: file
---

::: warning 注意
对于 Shamrock 尚未实现的 API，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

## 上传私聊文件

该接口用于上传群文件。

终结点: `/upload_private_file`

### 参数

| 字段     | 类型   | 说明         |
| -------- | ------ | ------------ |
| user_id | int64  | 目标         |
| file     | string | 本地文件路径 |
| name     | string | 储存名称     |

## 上传群文件

该接口用于上传群文件。

终结点: `/upload_group_file`

### 参数

| 字段     | 类型   | 说明         |
| -------- | ------ | ------------ |
| group_id | int64  | 群号         |
| file     | string | 本地文件路径 |
| name     | string | 储存名称     |

::: warning 注意
参数 `folder`在Shamrock不受支持。 
:::

### 参数

| 字段     | 类型   | 说明         |
| -------- | ------ | ------------ |
| group_id | int64  | 群号         |
| file     | string | 本地文件路径 |
| name     | string | 储存名称     |

## 删除群文件

该接口用于删除群文件。

终结点: `/delete_group_file`

### 参数

| 字段     | 类型   | 说明                             |
| -------- | ------ | -------------------------------- |
| group_id | int64  | 群号                             |
| file_id  | string | 文件ID 参考 [File](#file) 对象   |
| busid    | int32  | 文件类型 参考 [File](#file) 对象 |

::: tip 提示
该 API 无响应数据
:::

## 创建群文件文件夹
该接口用于创建群文件文件夹。

::: warning 注意
仅能在根目录创建文件夹
:::

终结点: `/create_group_file_folder`

### 响应

| 字段      | 类型   | 说明       |
| --------- | ------ | ---------- |
| msg_id  | int32  | 文件消息id       |

::: tip 提示
该 API 无响应数据
:::

## 删除群文件文件夹

该接口用于删除群文件文件夹。

终结点: `/delete_group_folder`

| 字段      | 类型   | 说明                                 |
| --------- | ------ | ------------------------------------ |
| group_id  | int64  | 群号                                 |
| folder_id | string | 文件夹ID 参考 [Folder](#folder) 对象 |

::: tip 提示
该 API 无响应数据
:::

## 获取群文件系统信息

该接口用于获取群文件系统信息。

终结点: `/get_group_file_system_info`

### 参数

| 字段     | 类型  | 说明 |
| -------- | ----- | ---- |
| group_id | int64 | 群号 |

### 响应

| 字段        | 类型  | 说明       |
| ----------- | ----- | ---------- |
| file_count  | int32 | 文件总数   |
| limit_count | int32 | 文件上限   |
| used_space  | int64 | 已使用空间 |
| total_space | int64 | 空间上限   |

## 获取群根目录文件列表

该接口用于获取群根目录文件列表。

### API 端点

`/get_group_root_files`

### 参数

| 字段     | 类型  | 说明 |
| -------- | ----- | ---- |
| group_id | int64 | 群号 |

### 响应

| 字段    | 类型                    | 说明       |
| ------- | ----------------------- | ---------- |
| files   | List<[File](#file)>     | 文件列表   |
| folders | List<[Folder](#folder)> | 文件夹列表 |

#### File

| 字段           | 类型   | 说明                    |
| -------------- | ------ | ----------------------- |
| group_id       | int32  | 群号                    |
| file_id        | string | 文件ID                  |
| file_name      | string | 文件名                  |
| busid          | int32  | 文件类型                |
| file_size      | int64  | 文件大小                |
| upload_time    | int64  | 上传时间                |
| dead_time      | int64  | 过期时间，永久文件恒为0 |
| modify_time    | int64  | 最后修改时间            |
| download_times | int32  | 下载次数                |
| uploader       | int64  | 上传者ID                |
| uploader_name  | string | 上传者名字              |

#### Folder

| 字段             | 类型   | 说明       |
| ---------------- | ------ | ---------- |
| group_id         | int32  | 群号       |
| folder_id        | string | 文件夹ID   |
| folder_name      | string | 文件名     |
| create_time      | int64  | 创建时间   |
| creator          | int64  | 创建者     |
| creator_name     | string | 创建者名字 |
| total_file_count | int32  | 子文件数量 |

## 获取群子目录文件列表

该接口用于获取群子目录文件列表。

### API 端点

`/get_group_files_by_folder`

### 参数

| 字段      | 类型   | 说明                                 |
| --------- | ------ | ------------------------------------ |
| group_id  | int64  | 群号                                 |
| folder_id | string | 文件夹ID 参考 [Folder](#folder) 对象 |

### 响应

| 字段    | 类型     | 说明       |
| ------- | -------- | ---------- |
| files   | File[]   | 文件列表   |
| folders | Folder[] | 文件夹列表 |

## 获取群文件资源链接

该接口用于获取群文件资源链接。

### API 端点

`/get_group_file_url`

### 参数

| 字段     | 类型   | 说明                             |
| -------- | ------ | -------------------------------- |
| group_id | int64  | 群号                             |
| file_id  | string | 文件ID 参考 [File](#file) 对象   |
| busid    | int32  | 文件类型 参考 [File](#file) 对象 |

### 响应

| 字段 | 类型   | 说明         |
| ---- | ------ | ------------ |
| url  | string | 文件下载链接 |

## 上传私聊文件 <Badge text="未实现" type="danger" />

该接口用于上传私聊文件。

### API 端点

`/upload_private_file`

### 参数

| 字段    | 类型   | 说明         |
| ------- | ------ | ------------ |
| user_id | int64  | 对方 QQ 号   |
| file    | string | 本地文件路径 |
| name    | string | 文件名称     |

::: warning 注意
只能上传本地文件, 需要上传 `http` 文件的话请先下载至本地
:::
