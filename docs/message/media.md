---
title: 媒体消息
icon: compact-disc
---

::: tip 提示
对于下述消息类型, 涉及 `文件地址` 的参数规则如下:

- 可以是本地文件路径, 以 `file://` 开头。
- 可以是 http(s) 链接, 以 `http://` 或 `https://` 开头。
- 可以是 base64 编码的数据, 但是必须以 `base64://` 开头。

:::

## 图片

### 参数

| 字段 | 类型   | 收  | 发 | 必填 | 说明                                  |
| ---- | ------ | --- |---| ---- |-------------------------------------|
| file | string | ✓   | ✓ | 是   | 图片文件地址                              |
| url  | string | ✓   | ✓ | 否   | 图片链接地址                              |
| type | string |  ✓   | x | 否   | 图片类型, 分为`show`, `flash`, `original` |
| subType | int32 |  ✓   | x | 否   | 图片子类型                               |

::: tabs

@tab CQ 码

```
[CQ:image,file=file:///sdcard/Pictures/shamrock.png]
```

@tab 消息段

```json
{
  "type": "image",
  "data": {
    "file": "file:///sdcard/Pictures/shamrock.png"
  }
}
```

:::

### 图片子类型

| value | 说明 |
| ----- | ---- |
| 0     | 正常图片                                  |
| 1     | 表情包, 在客户端会被分类到表情包图片并缩放显示 |
| 2     | 热图                                      |
| 3     | 斗图                                      |
| 4     | 智图?                                     |
| 7     | 贴图                                      |
| 8     | 自拍                                      |
| 9     | 贴图广告?                                  |
| 10    | 有待测试                                   |
| 13    | 热搜图                                    |

## 语音

### 参数

| 字段  | 类型   | 收  | 发  | 必填 | 说明           |
| ----- | ------ | --- | --- | ---- | -------------- |
| file  | string | ×   | ✓   | 是   | 语音文件地址   |
| url   | string | ✓   | ✓   | 否   | 语音链接地址   |
| magic | bool   | ×   | ✓   | 否   | 是否为魔法语音 |

::: tabs

@tab CQ 码

```
[CQ:record,file=file:///sdcard/Music/shamrock.mp3]
```

@tab 消息段

```json
{
  "type": "record",
  "data": {
    "file": "file:///sdcard/Music/shamrock.mp3"
  }
}
```

:::

::: warning 注意
发送语音消息需要安装语音引擎，可以在 [这里](../advanced/voice.md) 查看。
:::

## 视频

### 参数

| 字段 | 类型   | 收  | 发  | 必填 | 说明         |
| ---- | ------ | --- | --- | ---- | ------------ |
| file | string | ×   | ✓   | 是   | 视频文件地址 |


::: tabs

@tab CQ 码

```
[CQ:video,file=file:///sdcard/Movies/shamrock.mp4]
```

@tab 消息段

```json
{
  "type": "video",
  "data": {
    "file": "file:///sdcard/Movies/shamrock.mp4"
  }
}
```

:::