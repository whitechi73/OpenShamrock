---
title: 应用配置
icon: cog
---

::: tip 提示
Shamrock 提供了一个图形化的配置界面，可进行简单的配置操作。  
大部分配置简单易于理解，我们仅仅介绍部分难于理解的配置选项。
:::

## 配置选项

### 强制平板模式

让 QQ 客户端 识别设备为平板，使其账号可在安卓和平板同时在线。

::: tip 提示
除了 WebSocket 相关功能，其他功能的配置进行修改立即生效，无需重新启动QQ。
不建议使用 CQ 码，因为在新一代机器人设计理念中，该操作过于落后，可能会出现许多问题。
:::

::: warning 注意
被动 WebSocket 在断线之后，每隔 5 秒尝试重新连接。
:::

## 目录定义

- 内部存储目录: `/storage/emulated/0` # 或 `/sdcard`
- QQ 主目录: `内部存储目录 + /Android/data/com.tencent.mobileqq`
- Shamrock 主目录: `QQ主目录 + /Tencent/Shamrock`

## 配置文件

将下方 JSON 文件创建在 `Shamrock 主目录 + /config.json`  
请确保 JSON 格式正确。

```json
{
    "rules": {
        "group_rule": {
            "black_list": [12345678], // 如果群号是`12345678`就跳过了哦！
            "white_list": []
        },
        "private_rule": {
            "black_list": [12345678],
            "white_list": []
        }
    },
    "default_token": null,
    "active_websocket": {
        "port": 5800, // 主动WS监听的端口
        "token": "aaaa1111,bbbb1111", // 同时允许两个token可使用|或,作为分割
        "heartbeat_interval": 15000 // 设置为null则默认15000毫秒作为心跳间隔，0则为无心跳
    },
    "passive_websocket": [
        {
            "address": "ws://xxxxxxxxx" // 这里是个例子，如果默认tk存在则使用默认token鉴权
        },
        {
            "address": "ws://aaaaaaaaa",
            "token": "aaa666", // 提供了特例化token，将不使用默认token
            "heartbeat_interval": 15000 // 设置为null则默认15000毫秒作为心跳间隔，0则为无心跳
        }
    ],
    "allow-temp-session": false // 是否允许临时消息
}
```

| 参数名称 | 类型 | 作用 | 例子 |
|---------|------|------|-----|
| default_token | string   | 默认token，**HTTP接口/主被动WS** 如果未单独定义token，则使用默认token   | aaa123456  |


> 记得把注释删掉哦？JSON5貌似也没有完全支持呢？该配置文件采用Json5标准！

## WebSocket认证方法

在HTTP Upgrade请求头中添加access_token或ticket或Authorization头

例：

```
GET / HTTP/1.1
Host: 192.168.3.4
Upgrade: websocket
Connection: upgrade
Sec-WebSocket-Key: wwwwwwwwwwwwwwwwwwwwww==
Sec-WebSocket-Version: 13
Authorization: aaaa1111
```

## 数据目录

大部分 Shamrock 的数据/缓存保存在 `Shamrock 主目录`  
其中的日志可作为 Issue 内容，截取部分提交。

```bash
.
├── tmpfiles # 临时文件目录
│   ├── logs # 日志目录
│   │   └── xxx.log # 日志文件
├── config.json # 配置文件
```
