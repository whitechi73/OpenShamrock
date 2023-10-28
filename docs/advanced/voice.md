---
title: 语音支持
icon: microphone
---

## 安装 SILK 语音引擎

Shamrock 的语音解码器已经模块化，你可以自行选择安装。  
如果未安装 SILK 语音引擎，Shamrock 则无法发送 mp3/flac/wav/ogg 等格式的语音消息。

为了完整支持语音消息，你需要安装 SILK 语音引擎。

- 下载 [AudioLibrary](https://github.com/linxinrao/Shamrock/blob/master/AudioLibrary.zip) 语音支持库
- 将全部文件解压到 `Shamrock 主目录` 下的 `lib` 文件夹中

关于 `Shamrock 主目录`，请参考 [目录定义](../guide/configuration.md#目录定义)。

::: tip 提示
如果没有 `lib` 文件夹，请自行创建。  
`lib` 文件夹内仅允许包含格式为 `.so` 的文件且不能包含子文件夹。
:::
