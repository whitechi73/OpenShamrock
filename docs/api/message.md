---
title: 消息相关
icon: comment
---

::: warning 注意
对于 Shamrock 尚未实现的 API，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

## 发送私聊消息

该接口用于发送私聊消息。

### API 端点

`/send_private_msg`

### 参数

| 字段        | 类型                          | 必须 | 说明             |
| ----------- | ----------------------------- | ---- | ---------------- |
| user_id     | int64                         | 是   | QQ 号            |
| message     | `string` / `object` / `array` | 是   | 消息内容         |
| auto_escape | bool                          | 否   | 是否解析 CQ 码（true为不解析）。 |
| recall_duration     | int64                         | 否   | 自动撤回时间间隔（毫秒）            |

message格式可为[消息段](../message/format.md#%E6%B6%88%E6%81%AF%E6%AE%B5)object，或[消息段组合](../message/format.md#%E7%BB%84%E5%90%88)array

### 响应

| 字段       | 类型  | 说明    |
| ---------- | ----- | ------- |
| message_id | int32 | 消息 ID |
| time       | int64 | 时间戳  |

## 发送群聊消息

该接口用于发送群聊消息。

### API 端点

`/send_group_msg`

### 参数

| 字段        | 类型                          | 必须 | 说明             |
| ----------- | ----------------------------- | ---- | ---------------- |
| group_id    | int64                         | 是   | 群号             |
| message     | `string` / `object` / `array` | 是   | 消息内容         |
| auto_escape | bool                          | 否   | 是否解析 CQ 码（true为不解析）。 |
| recall_duration     | int64                         | 否   | 自动撤回时间间隔（毫秒）            |

message格式同`/send_private_msg`

### 响应

| 字段       | 类型  | 说明    |
| ---------- | ----- | ------- |
| message_id | int32 | 消息 ID |
| time       | int64 | 时间戳  |

## 发送消息

该接口用于发送消息。

### API 端点

`/send_msg`

### 参数

| 字段         | 类型                          | 必须 | 说明             |
| ------------ | ----------------------------- | ---- | ---------------- |
| message_type | string                        | 是   | 消息类型         |
| user_id      | int64                         | 是   | QQ 号            |
| group_id     | int64                         | 是   | 群号             |
| discuss_id   | int64                         | 是   | 讨论组号         |
| message      | `string` / `object` / `array` | 是   | 消息内容         |
| auto_escape  | bool                          | 否   | 是否解析 CQ 码（true为不解析）。 |
| recall_duration     | int64                         | 否   | 自动撤回时间间隔（毫秒）            |

message格式同`/send_private_msg`

::: warning 注意
当前发送消息的 API 暂不支持发送讨论组消息。
:::

### 响应

| 字段       | 类型  | 说明    |
| ---------- | ----- | ------- |
| message_id | int32 | 消息 ID |
| time       | int64 | 时间戳  |

## 获取消息

### API 端点

`/get_msg`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| message_id | int32 | 是   | 消息 ID |

### 响应

| 字段         | 类型                      | 说明       |
| ------------ | ------------------------- | ---------- |
| time         | int64                     | 时间戳     |
| message_type | string                    | 消息类型   |
| message_id   | int32                     | 消息 ID    |
| real_id      | int32                     | 真实 ID    |
| sender       | Object<[Sender](#sender)> | 发送人信息 |
| message      | object                    | 消息体     |
| group_id     | int64                     | 群号       |
| target_id     | int64                     | 消息目标（私聊）       |
| peer_id      | int64                     | 消息接收者，群聊是群号，私聊时是目标QQ       |

> `peer_id`是其他同类框架所表达的`target_id`!

#### Sender

| 字段     | 类型   | 说明  |
| -------- | ------ | ----- |
| user_id  | int64  | QQ 号 |
| nickname | string | 昵称  |
| sex      | string | 性别  |
| age      | int32  | 年龄  |
| uid      | string | UID   |

## 撤回消息

该接口用于撤回消息。

### API 端点

`/delete_msg`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| message_id | int32 | 是   | 消息 ID |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。。

## 获取历史消息

### API 端点

`/get_history_msg`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| message_type | string | 是   | 消息 类型 |
| user_id | int64 | 否   | 私聊QQ |
| group_id | int64 | 否   | 群号 |
| count | int32 | 否 | 获取的消息数量（默认为20）|
| message_seq | int32 | 否 | 起始消息的message_id（默认为0，表示从最后一条发言往前） |

### 响应

| 字段         | 类型                      | 说明       |
| ------------ | ------------------------- | ---------- |
| messages         | Message[]                     | 消息集     |

#### Message

| 字段         | 类型                      | 说明       |
| ------------ | ------------------------- | ---------- |
| time         | int64                     | 时间戳     |
| message_type | string                    | 消息类型   |
| message_id   | int32                     | 消息 ID    |
| real_id      | int32                     | 真实 ID    |
| sender       | Object<[Sender](#sender)> | 发送人信息 |
| message      | object                    | 消息体     |
| group_id     | int64                     | 群号       |
| target_id     | int64                     | 消息目标（私聊）       |
| peer_id      | int64                     | 消息接收者，群聊是群号，私聊时是目标QQ       |

> `peer_id`是其他同类框架所表达的`target_id`!

## 获取群聊历史消息

### API 端点

`/get_group_msg_history`

### 参数

| 字段       | 类型    | 必须 | 说明                              |
| ---------- |-------| ---- |---------------------------------|
| group_id | int64 | 是   | 群号                              |
| count | int32 | 否 | 获取的消息数量（默认为20）                  |
| message_seq | int32 | 否 | 起始消息的message_id（默认为0，表示从最后一条发言往前） |

### 响应

| 字段         | 类型                      | 说明       |
| ------------ | ------------------------- | ---------- |
| messages         | Message[]                     | 消息集     |

## 清除本地缓存消息

该接口用于清除本地消息缓存。

### API 端点

`/clear_msgs`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| message_type | string | 是   | 消息 类型 |
| user_id | int64 | 否   | 私聊QQ |
| group_id | int64 | 否   | 群号 |

### 响应

该接口将返回处理结果，其中 `data` 字段无数据。

## 获取合并转发消息内容

获取合并转发内容

### API 端点

`/get_forward_msg`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| id | string | 是   | 消息资源ID（卡片消息里面的resId） |

> 由于QQ内部错误，该接口可能导致闪退等问题的出现！一般是闪退一次后再次重新启动便不再闪退，但是可能无法获取合并转发的内容！

### 响应

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "messages": [
      {
        "time": 1699375697,
        "message_type": "private",
        "message_id": 123456,
        "real_id": 0,
        "sender": {
          "user_id": 114514,
          "nickname": "伏秋洛~",
          "sex": "unknown",
          "age": 0,
          "uid": "u_xxxx"
        },
        "message": [
          {
            "type": "text",
            "data": {
              "text": "aaaaaaaaaa"
            }
          }
        ],
        "peer_id": 114514,
        "target_id": 114514
      }
    ]
  },
  "echo": ""
}
```

## 发送群聊合并转发

发送群聊合并转发。

### API 端点

`/send_group_forward_msg`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| group_id | int64 | 是   | 发送到的目标群号 |
| messages | foward message[] | 合并转发消息集 |

### 响应

> 由于QQ限制，该接口的响应结果暂不具备意义，其中：message_id不匹配、forward_id为空。

| 字段       | 类型  | 说明    |
| ---------- | ----- | ------- |
| message_id | int32 | 消息 ID |
| forward_id | int32 | 转发 ID |

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "message_id": 251425915,
    "forward_id": ""
  }
}
```

### 示例

直接引用消息的合并转发，id为`消息id`：

```json
[
	{
		"type": "node",
		"data": {
			"id": "123"
		}
	},
	{
		"type": "node",
		"data": {
			"id": "456"
		}
	}
]
```

::: warning 注意
Shamrock 不同于 `go-cqhttp` ，消息节点无法自定义发送者QQ号（设置头像）与昵称。
:::

自定义消息合并转发：

```json
[
	{
		"type": "node",
		"data": {
			"content": [
				{
					"type": "text",
					"data": {
						"text": "测试消息1"
					}
				}
			]
		}
	},
	{
		"type": "node",
		"data": {
			"content": "[CQ:image,file=xxxxx]测试消息2"
		}
	}
]
```

引用自定义混合合并转发:

```json
[
    {
        "type": "node",
        "data": {
            "content": "我是自定义消息",
        }
    },
    {
        "type": "node",
        "data": {
            "id": "123"
        }
    }
]
```

## 发送私聊合并转发

发送私聊合并转发。

### API 端点

`/send_private_forward_msg`

### 参数

| 字段       | 类型  | 必须 | 说明    |
| ---------- | ----- | ---- | ------- |
| user_id | int64 | 是   | 发送到的目标QQ |
| messages | foward message[] | 合并转发消息集 |

### 响应

同 [/send_private_forward_msg](#发送群聊合并转发)
