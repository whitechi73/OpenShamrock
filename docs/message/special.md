---
title: 特殊消息
icon: paper-plane
---

## 戳一戳

::: warning 注意
Shamrock 对于戳一戳的定义与 `go-cqhttp` 不同。
:::

### 参数

| 字段     | 类型 | 收  | 发  | 必填 | 说明                  |
| -------- | ---- | --- | --- | ---- | --------------------- |
| type     | int  | ✓   | ✓   | 是   | 戳一戳类型            |
| id       | int  | ✓   | ✓   | 是   | 戳一戳 ID             |
| strength | int  | ✓   | ✓   | 否   | 戳一戳强度(1-5 默认1) |

### CQ 码

```
[CQ:poke,type=1,id=10000]
```

### 消息段

```json
{
  "type": "poke",
  "data": {
    "type": 1,
    "id": 10000,
    "strength": 1
  }
}
```

## 戳一戳(双击头像)

### 参数

| 字段 | 类型 | 收  | 发  | 必填 | 说明 |
| ---- | ---- | --- | --- | ---- | ---- |
| id   | int  | ✓   | ✓   | 是   | QQ号 |

### CQ 码

```
[CQ:touch,id=123456]
```

### 消息段

```json
{
  "type": "touch",
  "data": {
    "id": 123456
  }
}
```

## 音乐

### 参数

| 字段 | 类型   | 收  | 发  | 必填 | 说明                 |
| ---- | ------ | --- | --- | ---- | -------------------- |
| type | string | ✓   | ✓   | 是   | 音乐类型(`qq`/`163`) |
| id   | int    | ✓   | ✓   | 是   | 音乐 ID              |

### CQ 码

```
[CQ:music,type=qq,id=123456]
```

### 消息段

```json
{
  "type": "music",
  "data": {
    "type": "qq",
    "id": 123456
  }
}
```

## 音乐(自定义)

### 参数

| 字段   | 类型   | 收  | 发  | 必填 | 说明                           |
| ------ | ------ | --- | --- | ---- | ------------------------------ |
| type   | string | ✓   | ✓   | 是   | 音乐类型(自定义请使用 `custom` |
| url    | string | ✓   | ✓   | 是   | 跳转链接                       |
| audio  | string | ✓   | ✓   | 是   | 音乐音频链接                   |
| title  | string | ✓   | ✓   | 是   | 标题                           |
| singer | string | ✓   | ✓   | 是   | 歌手                           |
| image  | string | ✓   | ✓   | 否   | 封面图片链接                   |

### CQ 码

```
[CQ:music,type=custom,url=https://example.com,audio=https://example.com/music.mp3,title=Music,singer=Music,image=https://example.com/image.jpg]
```

### 消息段

```json
{
  "type": "music",
  "data": {
    "type": "custom",
    "url": "https://example.com",
    "audio": "https://example.com/music.mp3",
    "title": "Music",
    "singer": "Music",
    "image": "https://example.com/image.jpg"
  }
}
```

## 天气

### 参数

| 字段 | 类型   | 收  | 发  | 必填 | 说明     |
| ---- | ------ | --- | --- | ---- | -------- |
| city | string | ✓   | ✓   | 否   | 城市名称 |
| code | string | ✓   | ✓   | 否   | 城市代码 |

### CQ 码

```
[CQ:weather,city=上海]
```

### 消息段

```json
{
  "type": "weather",
  "data": {
    "city": "上海"
  }
}
```

## 位置

### 参数

| 字段    | 类型   | 收  | 发  | 必填 | 说明 |
| ------- | ------ | --- | --- | ---- | ---- |
| lat     | float  | ✓   | ✓   | 是   | 纬度 |
| lon     | float  | ✓   | ✓   | 是   | 经度 |
| title   | string | ✓   | ×   | 否   | 标题 |
| content | string | ✓   | ×   | 否   | 内容 |

### CQ 码

```
[CQ:location,lat=39.915168,lon=116.403875]
```

### 消息段

```json
{
  "type": "location",
  "data": {
    "lat": 39.915168,
    "lon": 116.403875
  }
}
```

## 链接分享

### 参数

| 字段    | 类型   | 收  | 发  | 必填 | 说明     |
| ------- | ------ | --- | --- | ---- | -------- |
| url     | string | ✓   | ✓   | 是   | 链接地址 |
| title   | string | ✓   | ×   | 是   | 标题     |
| content | string | ✓   | ×   | 否   | 内容     |
| image   | string | ✓   | ×   | 否   | 图片链接 |
| file    | string | ✓   | ×   | 否   | 文件链接 |

### CQ 码

```
[CQ:share,url=https://example.com,title=Example,content=Example,image=https://example.com/image.jpg,file=https://example.com/file.zip]
```

### 消息段

```json
{
  "type": "share",
  "data": {
    "url": "https://example.com",
    "title": "Example",
    "content": "Example",
    "image": "https://example.com/image.jpg",
    "file": "https://example.com/file.zip"
  }
}
```

## 礼物

### 参数

| 字段 | 类型 | 收  | 发  | 必填 | 说明    |
| ---- | ---- | --- | --- | ---- | ------- |
| qq   | int  | ✓   | ✓   | 是   | QQ 号   |
| id   | int  | ✓   | ✓   | 是   | 礼物 ID |

### CQ 码

```
[CQ:gift,qq=123456,id=10000]
```

### 消息段

```json
{
  "type": "gift",
  "data": {
    "qq": 123456,
    "id": 10000
  }
}
```
