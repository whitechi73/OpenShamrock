---
title: 请求与响应
icon: server
---

::: tip 提示
Shamrock 为您提供了一个支持 OneBot 标准的 HTTP API。  
您可以通过发送 HTTP 请求来与 Shamrock 进行交互。
:::

## 请求

::: tip 提示
Shamrock 目前支持 GET 和 POST 两种请求方式。  
在大部分情况下，您可以使用 GET 请求来与 Shamrock 进行交互。  
但是，如果您需要向 Shamrock 发送大量数据，或者需要向 Shamrock 发送二进制数据，您需要使用 POST 请求。
:::

### GET 请求

GET 请求的 URL 由以下部分组成：

```text
http://<host>:<port>/<endpoint>?<params>
```

链接中的含义如下：

- `<host>`：Shamrock 的 IP 地址或域名
- `<port>`：Shamrock 的 HTTP API 端口
- `<endpoint>`：Shamrock 的 HTTP API 端点
- `<params>`：HTTP GET 请求的参数

### POST 请求

POST 请求的 URL 由以下部分组成：

```text
http://<host>:<port>/<endpoint>
```

链接中的含义如下：

- `<host>`：Shamrock 的 IP 地址或域名
- `<port>`：Shamrock 的 HTTP API 端口
- `<endpoint>`：Shamrock 的 HTTP API 端点

#### 请求格式

POST 请求的数据格式为 JSON

```json
{
  "param1": "value1",
  "param2": "value2",
  ...
}
```

POST 请求的数据格式为表单

```text
param1=value1&param2=value2&...
```

大多数情况下，推荐使用 JSON 格式的 POST 请求。

### WebSocket 请求

Shamrock 支持使用 WebSocket 进行通信。

可选的 WebSocket 地址有两种：

- `ws://<host>:<port>`
- `ws://<host>:<port>/api`

区别在于，`/` 除了发送和响应 API 请求外，还支持事件上报功能。

### 请求格式

Shamrock 使用 WebSocket 时，请求的数据格式为 JSON

```json
{
  "action": "send_private_msg", // 请求 API 端点
  "params": {
    // 请求参数
    "user_id": 10000,
    "message": "hello"
  },
  "echo": "123456" // 自定义的回显字段
}
```

对于 `echo` 字段，Shamrock 会在响应中原样返回。

## 响应

Shamrock 的响应格式为 JSON

```json
{
  "status": "ok", // 状态，ok 为成功，其他将在下文中详细说明
  "retcode": 0, // 返回码，0 为成功，非 0 为失败
  "msg": "", // 错误信息，仅在 API 调用失败时出现
  "wording": "", // 对错误信息的描述，仅在 API 调用失败时出现
  "data": {
    // 响应数据
    "message_id": 123456
  },
  "echo": "123456" // 请求中的回显字段
}
```

### 状态

Shamrock 的响应状态有以下几种：

- `ok`：成功
- `failed`：失败
