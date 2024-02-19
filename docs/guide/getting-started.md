---
title: 快速开始
icon: rocket
---

::: warning 注意
`Shamrock` 的更新会围绕一个稳定的版本，如果盲目升级，可能导致 `Shamrock` 不可用。  
`Shamrock` 仍然处于快速开发阶段，可能会有大量 `API` 在未来版本中被删除或修改。  
请不要过度依赖实验室中的功能，以免造成不必要的损失。
:::

## 下载

::: tip 提示
目前推荐您下载 开发版本 的 `Shamrock`
:::

### 稳定版本

- 要下载 `Shamrock` 的稳定版本，请访问 [GitHub Releases](https://github.com/whitechi73/OpenShamrock/releases)

### 开发版本

- 要下载 `Shamrock` 的开发版本(推荐)，请访问 [GitHub Actions](https://github.com/whitechi73/OpenShamrock/actions/workflows/build-apk.yml)

## 部署

::: warning 注意
请使用 `Shamrock` 兼容的 `QQ` 客户端部署，见 [支持的QQ版本](./faq.md#支持的qq版本)

如果您使用了 `QRSpeed/ShamrockNative` 有关的插件，请确保 `Shamrock` 存活。  
无论什么情况都请确保 `QQ` 客户端 存活。  
禁止对 `QQ` 客户端 隐藏 `Shamrock`，这将导致无法运行。  
首次启动，必须打开 `Shamrock`，否则无法推送配置文件导致失败。
:::

### 模拟器上部署

在Mumu模拟器、逍遥模拟器......各种模拟器，其中对Shamrock兼容较好的是 **Mumu模拟器** ，其它模拟器在测试情况下都出现高版本 `QQ` 闪退的问题。

::: warning 注意
`Shamrock` 必须是 `ALL版本` 才能在模拟器正常使用
:::

#### Magisk+Lsposed

推荐的是 `Xposed` 的 `Lsposed` 框架，而不是 `EdXposed`，在测试情况下, `EdXP` 出现了无法注入的问题。

- 安装 `Magisk` 方法,见 [52pojie论坛](https://www.52pojie.cn/thread-1583586-1-1.html)
- 安装 `Lsposed` 方法,见 [Magisk中文网](https://magiskcn.com/lsposed-install)

#### Lspatch

查看 [使用LSPatch](#使用-lspatch)

### 在Linux类服务器上部署（使用docker）

这个选择过于多元化，你可以使用 `redroid`, `docker-android`，需要注意的是部分框架要求开起虚拟化才能使用哦！目前依旧是采用 `Lspatch+Shamrock` 方案在 `docker` 部署，因为安装 `magisk` 类需要修补镜像，难以实现。

查看 [使用LSPatch](#使用-lspatch)

### 在PVE上使用

#### 部署Windows

使用PVE安装任意Windows系统之后，阅读文章
[PVE开启嵌套虚拟化](https://zhuanlan.zhihu.com/p/354034712?utm_psn=1695915211926863872)

之后可在系统内使用 [安卓模拟器部署](#模拟器上部署)。

#### 部署BlissOS

操作视频参考[PVE下安装BlissOS及Magisk,LSP](https://www.bilibili.com/video/BV1Mj411e7V9)  
之后可以直接使用 `OpenShamrock`

### 在Linux KVM部署

参考文章：[KVM上部署Android](https://cloud.tencent.com/developer/article/1484145)
该文章使用的安卓版本可能较低，请使用安卓9+系统

### ~~在WSA上部署~~

`WSA` 拥有自带 `Magisk` 的版本，但是 `QQ` 在 `WSA` 在第二次启动时会闪退，怀疑为热更新问题。

### 有 XP 环境

- 打开 `QQ` 客户端，登录你的 `QQ` 账号
- 安装 `Shamrock` 并在 `Xposed` 启用 `Shamrock` 模块，如果使用 `LSPosed` 则需要勾选模块作用域(默认QQ)
- 启动 `Shamrock` 并`重新启动 QQ 客户端`，如果环境为 `Xposed` 则需要重启手机
- 此时 `Shamrock` 会显示已激活(需要成功登陆，才会显示已激活)

### 无 Root 环境

#### 使用 LSPatch

- 打开 `LSPatch` 并在 `管理` 页面选择 `+` 新建修补，可以选择从存储目录选择 `QQAPK` 或者直接使用已经安装过的 `QQ`
- 修补模式默认且应该优先选择 `本地模式` ，这样方便直接更新 `Shamrock` 模块而不用重新修补，缺点是需要 `LSPatch` 保持后台运行
- 其他配置保持默认，然后点击 `开始修补` ，修补完成后会提示安装(如果已经安装会提示卸载)
- 安装 `Shamrock` 模块后在 `管理` 页面点击修补好的 `QQ` 选择 `模块作用域` 勾选上 `Shamrock` 模块然后保存
- 启动 `Shamrock` 并 `重新启动 QQ 客户端`
- 此时 `Shamrock` 会显示已激活

::: warning 注意
使用 `本地模式` 修补后需要保持 `LSPatch` 在后台运行，优点是模块更新无需重新修补 `QQ`

使用 `集成模式` 修补后无需保持 `LSPatch` 在后台运行，缺点是模块更新后需要重新修补 `QQ`
:::

#### 使用 VirtualXposed

::: warning 注意
在 Android 12 以上的系统中，使用 `VirtualXposed` 会导致闪退。
:::

#### 使用 太极

::: warning 注意
暂不支持太极使用，正在申请。
:::
