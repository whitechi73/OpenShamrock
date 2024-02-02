---
title: 频道相关
icon: user-group
---

::: warning 注意
对于 Shamrock 尚未实现的 API，会在标题添加标记 <Badge text="未实现" type="danger" vertical="baseline" />
:::

## 获取频道系统内BOT的资料

该接口用于获取频道系统内BOT的资料。

### API 端点

`/get_guild_service_profile`

### 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "nickname": "田所浩二",
    "tiny_id": 1145141919810,
    "avatar_url": "http://thirdqq.qlogo.cn/g?b=oidb&k=***&kti=***&s=0&t=***"
  },
  "echo": 123446
}
```

## 获取频道列表

获取频道列表，数据相比于Go-CQHTTP会有一点不一样。

### API 端点

`/get_guild_list`

### 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "guild_list": [
      {
        "guild_id": 111111111111111,
        "guild_name": "北京大学频道",
        "guild_display_id": "abcdefg",
        "profile": "北京大学交流频道",
        "status": {
          "is_enable": true,
          "is_banned": false,
          "is_frozen": false
        },
        "owner_id": 22222222222222,
        "shutup_expire_time": 0,
        "allow_search": true
      }
    ]
  },
  "message": "success",
  "echo": 111
}
```

## 通过访客获取频道元数据

获取频道元数据，例如当前成员数量之类。

### API 端点

`/get_guild_meta_by_guest`

### 参数

| 字段      | 类型     | 说明     |
|---------|--------|--------|
| guild_id | uint64  | 频道ID     |

### 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "guild_id": 11111111111,
    "guild_name": "北京大学交流频道",
    "guild_profile": "",
    "create_time": 1606878500,
    "max_member_count": 100000,
    "max_robot_count": 100,
    "max_admin_count": 50,
    "member_count": 6241,
    "owner_id": 2222222221,
    "guild_display_id": ""
  },
  "echo": 111
}
```

## 获取子频道列表

获取一个频道的子频道(channel)列表。

### API 端点

`/get_guild_channel_list`

### 参数

| 字段      | 类型     | 说明     |
|---------|--------|--------|
| guild_id | uint64  | 频道ID     |
| refresh | bool | 是否刷新数据，默认`false` |

### 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "channel_list": [
      {
        "owner_guild_id": 1111111111111111111,
        "channel_id": 639093000,
        "channel_uin": 639093000,
        "guild_id": "1111111111111111111",
        "channel_type": 2,
        "channel_name": "Test",
        "create_time": 1606879350,
        "max_member_count": 99,
        "creator_tiny_id": 124105218677239793,
        "talk_permission": 1,
        "visible_type": 1,
        "current_slow_mode": 0,
        "slow_modes": [],
        "icon_url": "",
        "jump_switch": 0,
        "jump_type": 0,
        "jump_url": "",
        "category_id": 0,
        "my_talk_permission": 2
      },
      {
        "owner_guild_id": 1111111111111111111,
        "channel_id": 639093001,
        "channel_uin": 639093001,
        "guild_id": "1111111111111111111",
        "channel_type": 1,
        "channel_name": "闲聊吹水",
        "create_time": 1606878501,
        "max_member_count": 0,
        "creator_tiny_id": 124105218677239793,
        "talk_permission": 1,
        "visible_type": 1,
        "current_slow_mode": 0,
        "slow_modes": [
          {
            "slow_mode_key": 0,
            "slow_mode_text": "关闭",
            "speak_frequency": 0,
            "slow_mode_circle": 0
          },
          {
            "slow_mode_key": 1,
            "slow_mode_text": "每分钟1条",
            "speak_frequency": 1,
            "slow_mode_circle": 60
          },
          {
            "slow_mode_key": 2,
            "slow_mode_text": "每分钟2条",
            "speak_frequency": 2,
            "slow_mode_circle": 60
          },
          {
            "slow_mode_key": 3,
            "slow_mode_text": "每分钟5条",
            "speak_frequency": 5,
            "slow_mode_circle": 60
          },
          {
            "slow_mode_key": 4,
            "slow_mode_text": "每分钟10条",
            "speak_frequency": 10,
            "slow_mode_circle": 60
          },
          {
            "slow_mode_key": 5,
            "slow_mode_text": "每5分钟1条",
            "speak_frequency": 1,
            "slow_mode_circle": 300
          },
          {
            "slow_mode_key": 6,
            "slow_mode_text": "每10分钟1条",
            "speak_frequency": 1,
            "slow_mode_circle": 600
          },
          {
            "slow_mode_key": 7,
            "slow_mode_text": "每15分钟1条",
            "speak_frequency": 1,
            "slow_mode_circle": 900
          },
          {
            "slow_mode_key": 8,
            "slow_mode_text": "每30分钟1条",
            "speak_frequency": 1,
            "slow_mode_circle": 1800
          },
          {
            "slow_mode_key": 9,
            "slow_mode_text": "每1小时1条",
            "speak_frequency": 1,
            "slow_mode_circle": 3600
          },
          {
            "slow_mode_key": 10,
            "slow_mode_text": "每12小时1条",
            "speak_frequency": 1,
            "slow_mode_circle": 43200
          },
          {
            "slow_mode_key": 11,
            "slow_mode_text": "每24小时1条",
            "speak_frequency": 1,
            "slow_mode_circle": 86400
          }
        ],
        "icon_url": "",
        "jump_switch": 0,
        "jump_type": 0,
        "jump_url": "",
        "category_id": 0,
        "my_talk_permission": 2
      }
    ]
  },
  "message": "success",
  "echo": 111
}
```

#### 已知子频道类型列表

| 类型 | 说明  |
|------|------|
| 1 | 文字频道 |
| 2 | 语音频道 |
| 5 | 直播频道 |
| 7 | 主题频道 |

## 获取频道成员列表

获取一个频道成员列表，但是因为数据量大，可能需要分页。

### API 端点

`/get_guild_member_list`

### 参数

| 字段      | 类型     | 说明     |
|---------|--------|--------|
| guild_id | uint64  | 频道ID     |
| next_token | string  | 不提供则从首页开始获取     |
| all | bool | 是否一次性获取完所有成员，默认`false` |
| refresh | bool | 是否刷新数据，默认`false` |

### 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "members": [
      {
        "tiny_id": 144115218185291865,
        "title": "频道助手",
        "nickname": "频道助手",
        "role_id": 2,
        "role_name": "小管家",
        "role_color": 4294936110,
        "join_time": 1606878501,
        "robot_type": 1,
        "type": 1,
        "in_black": false,
        "platform": 0
      }
    ],
    "next_token": "0800100118032001",
    "finished": true
  },
  "echo": ""
}
```

## 单独获取频道成员资料

单独获取频道成员信息，附带有权限信息和身份组哦~！

### API 端点

`/get_guild_member_profile`

### 参数

| 字段      | 类型     | 说明     |
|---------|--------|--------|
| guild_id | uint64  | 频道ID     |
| user_id | uint64  | 成员`tinyId`     |

### 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "tiny_id": 123456,
    "nickname": "***",
    "avatar_url": "https://qqchannel-profile-1251316161.file.myqcloud.com/***",
    "join_time": 1606878500,
    "roles": [
      {
        "role_id": "4",
        "role_name": "频道主",
        "color": 4294917938,
        "permission": [
          {
            "root_id": 10000,
            "child_ids": [
              10001,
              10002,
              10003,
              10004,
              10005
            ]
          },
          {
            "root_id": 20000,
            "child_ids": [
              20001,
              20002,
              20003,
              20004,
              20005,
              20006,
              20007,
              20008,
              20009,
              20010,
              20011,
              20012,
              20013,
              20014,
              20015,
              20018,
              20019
            ]
          },
          {
            "root_id": 30000,
            "child_ids": [
              30001,
              30002,
              30003,
              30004,
              30005,
              30006,
              30007,
              90002
            ]
          },
          {
            "root_id": 40000,
            "child_ids": [
              40001,
              40002
            ]
          },
          {
            "root_id": 50000,
            "child_ids": [
              50001
            ]
          },
          {
            "root_id": 60000,
            "child_ids": [
              60001
            ]
          },
          {
            "root_id": 70000,
            "child_ids": [
              70001,
              70002,
              70003,
              70004,
              70005,
              70006,
              70007
            ]
          },
          {
            "root_id": 80000,
            "child_ids": [
              80001,
              80002
            ]
          },
          {
            "root_id": 90000,
            "child_ids": [
              90001,
              30003
            ]
          },
          {
            "root_id": 100000,
            "child_ids": [
              100001,
              100002
            ]
          },
          {
            "root_id": 1,
            "child_ids": [
              1001,
              1002,
              1003,
              1004,
              1005
            ]
          },
          {
            "root_id": 2,
            "child_ids": [
              2001,
              2002,
              2003,
              2004,
              2005,
              2006,
              2007,
              2008,
              2009,
              2010,
              2011,
              2012,
              2013,
              2014,
              2015,
              2016,
              2017,
              2018
            ]
          },
          {
            "root_id": 3,
            "child_ids": [
              3001,
              3002,
              3003,
              3004,
              3005,
              3006
            ]
          },
          {
            "root_id": 4,
            "child_ids": [
              4001,
              4002,
              4003,
              4004,
              4005,
              4006,
              4007,
              4008
            ]
          },
          {
            "root_id": 5,
            "child_ids": [
              5001
            ]
          },
          {
            "root_id": 6,
            "child_ids": [
              6001,
              6002,
              6003
            ]
          }
        ],
        "type": 0,
        "display_name": "频道主"
      },
      {
        "role_id": "15",
        "role_name": "15活跃值",
        "color": 4278190080,
        "permission": [],
        "type": 100,
        "display_name": ""
      }
    ]
  },
  "echo": 111
}
```

## 发送信息到子频道

发送频道内信息，需要单独的API哦，不要使用`/send_message`去发频道消息，发不出去的~~

### API 端点

`/send_guild_channel_msg`

### 参数

| 字段      | 类型     | 说明     |
|---------|--------|--------|
| guild_id | uint64  | 频道ID     |
| channel_id | uint64  | 子频道ID  |
| message | string or `Message`  | 消息体，可为消息段或者CQ码  |
| auto_escape | bool | 是否解析CQ码，`true`为不解析，默认`false` |
| retry_cnt | int32 | 消息发送失败，最大重试次数，默认`3` |
| recall_duration | int64 | 自动撤回间隔(毫秒)，默认不撤回 |

### 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "message_id": 1933593189,
    "time": 1706909190
  },
  "echo": 111
}
```

## 获取话题频道帖子

该API接口已经被遗弃！

## 获取频道帖子广场帖子

新的获取帖子广场的帖子哦！

### API 端点

`/get_guild_feeds`

### 参数

| 字段      | 类型     | 说明     |
|---------|--------|--------|
| guild_id | uint64  | 频道ID     |
| from | uint32  | 开始获取的位置  |

### 响应示例

> 该请求携带了大量原生响应数据，无法详细介绍，请自行测试！

## 获取频道角色列表

获取身份组列表，包括隐藏的身份组哦~~

### API 端点

`/get_guild_roles`

### 参数

| 字段      | 类型     | 说明     |
|---------|--------|--------|
| guild_id | uint64  | 频道ID     |

### 响应示例

```json
{
  "status": "ok",
  "retcode": 0,
  "data": {
    "roles": [
      {
        "argb_color": 4286151052,
        "disabled": true,
        "independent": false,
        "max_count": 1000,
        "member_count": 0,
        "owned": false,
        "role_id": 1,
        "role_name": "普通成员",
        "permission": []
      }
    ]
  },
  "echo": 111
}
```

## 获取频道消息

该接口不会实现，因为您可以调用`/get_msg`来获取来自频道的消息，无需实现一个专属的接口。

