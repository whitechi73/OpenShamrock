import { defineUserConfig } from 'vuepress'
import { searchProPlugin } from 'vuepress-plugin-search-pro'
import theme from './config/theme'

export default defineUserConfig({
  base: '/OpenShamrock/',
  title: 'OpenShamrock',
  lang: 'zh-CN',
  port: 1421,
  head: [
    [
      'meta',
      {
        name: 'viewport',
        content: 'width=device-width,initial-scale=1,user-scalable=no'
      }
    ],
    ['script', { async: true, src: 'https://umami.zhenxin.me/script.js', 'data-website-id': 'a3220f2d-2267-4b95-b4aa-a5964cda0a0d' }]
  ],
  theme,
  plugins: [
    searchProPlugin({
      indexContent: true,
      hotKeys: []
    })
  ]
})
