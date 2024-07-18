<div align="center">

![][banner]

[![][actions]][actions-link]
[![][releases]][releases-link]
[![][downloads]][releases-link]

![][onebot-11]
![][onebot-12]
[![][license]](LICENSE)

[下载][download-link] | [部署][deploy-link] | [接口][api-link] | [文档][docs-link]

</div>

## 简介

☘ 基于 Lsposed(**Non**-Riru) 实现 Kritor 标准的 QQ 机器人框架！

> 本项目仅提供学习与交流用途，请在24小时内删除。   
> 本项目目的是研究 Xposed 和 LSPosed 框架的使用。 Epic 框架开发相关知识。  
> Riru可能导致封禁，请减少使用。
> 如有违反法律，请联系删除。
> 请勿在任何平台宣传，宣扬，转发本项目，请勿恶意修改企业安装包造成相关企业产生损失，如有违背，必将追责到底。
> 
> 社区地址：[discord](https://discord.gg/MKR2wz863h)

## 兼容|迁移|替代 说明

仅支持QQ9.0.70以上的版本，低版本问题将不再修复与处理。

- 一键移植：本项目基于 go-cqhttp 的文档进行开发实现。
- 平行部署：可多平台部署。  

## 相关项目

<table>
<tr>
  <td><a href="https://github.com/LagrangeDev/Lagrange.Core">Lagrange.Core</a></td>
  <td>NTQQ 的协议实现</td>
</tr>
<tr>
  <td><a href="https://github.com/whitechi73/OpenShamrock">OpenShamrock</a></td>
  <td>基于 Xposed 实现 OneBot 标准的机器人框架（👈你在这里</td>
</tr>
<tr>
  <td><a href="https://github.com/chrononeko/chronocat">Chronocat</a></td>
  <td>基于 Electron 的、模块化的 Satori 框架</td>
</tr>
</table>

## 权限声明

> 如出现未在此处声明的权限，请警惕 Shamrock 是否被修改/植入恶意代码

- 网络访问权限: Shamrock 进程需要使用 HTTP API 来进行一些操作
- [Hook 系统框架][hook-system]: 为了保证息屏状态下服务不被杀死，Shamrock 需要 Hook 系统框架
- 后台启动 Activity: 自动唤醒 QQ 时需要使用

## 语音解码

请参考文档中 [语音支持][voice-support] 部分

## 贡献说明

<img src="https://github.com/whitechi73/OpenShamrock/assets/98259561/f04d60bc-ec40-41fc-bc15-62c146f1a1f1" width="160px" alt="Shamrock"> **我可爱吗？欢迎你的到来，这里是一个很大的地方，有着无限可能，主要是有你啦！**

## 鸣谢

感谢[**JetBrains**](https://www.jetbrains.com/zh-cn/community/opensource/#support)提供的开源开发许可证，JetBrains 通过为核心项目贡献者免费提供一套一流的开发者工具来支持非商业开源项目。

[<img src=".github/jetbrains-variant-3.png" width="200"/>](https://www.jetbrains.com/zh-cn/community/opensource/#support)

## 开源协议

本项目使用 [GPL-3.0](LICENSE) 协议开放源代码

```text
Shamrock - OneBot standard QQ robot framework based on Xposed implementation
Copyright (C) 2023 ~ 2024 Shamrock Team
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
```

## 贡献者

[![][contrib-image]][contrib-link]

[banner]: https://socialify.git.ci/whitechi73/OpenShamrock/image?description=1&forks=1&issues=1&logo=https%3A%2F%2Fwhitechi73.github.io%2FOpenShamrock%2Fshamrock.jpg&pattern=Plus&pulls=1&stargazers=1&theme=Auto

[actions]: https://img.shields.io/github/actions/workflow/status/whitechi73/OpenShamrock/build-apk.yml?style=for-the-badge

[actions-link]: https://github.com/whitechi73/OpenShamrock/actions/workflows/build-apk.yml

[releases]: https://img.shields.io/github/v/release/whitechi73/OpenShamrock?style=for-the-badge

[releases-link]: https://github.com/whitechi73/OpenShamrock/releases

[downloads]: https://img.shields.io/github/downloads/whitechi73/OpenShamrock/total?style=for-the-badge

[license]: https://img.shields.io/github/license/whitechi73/OpenShamrock?style=for-the-badge

[onebot-11]: https://img.shields.io/badge/OneBot-11-black?style=for-the-badge

[onebot-12]: https://img.shields.io/badge/OneBot-12-black?style=for-the-badge

[download-link]: https://whitechi73.github.io/OpenShamrock/guide/getting-started.html#%E4%B8%8B%E8%BD%BD

[deploy-link]: https://whitechi73.github.io/OpenShamrock/guide/getting-started.html#%E9%83%A8%E7%BD%B2

[api-link]: https://whitechi73.github.io/OpenShamrock/api

[docs-link]: https://whitechi73.github.io/OpenShamrock/

[hook-system]: https://github.com/whitechi73/OpenShamrock/blob/master/xposed/src/main/java/moe/fuqiuluo/shamrock/xposed/loader/KeepAlive.kt

[voice-support]: https://whitechi73.github.io/OpenShamrock/advanced/voice.html

[contrib-image]: https://contrib.rocks/image?repo=whitechi73/OpenShamrock

[contrib-link]: https://github.com/whitechi73/OpenShamrock/graphs/contributors

