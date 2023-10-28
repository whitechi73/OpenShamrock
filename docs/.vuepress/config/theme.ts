import { hopeTheme } from 'vuepress-theme-hope'
import { shamrockNavbar } from './navbar'
import { shamrockSidebar } from './sidebar'

export default hopeTheme({
  favicon: '/shamrock.webp',
  logo: '/shamrock.webp',
  iconAssets: 'fontawesome-with-brands',
  repo: 'whitechi73/OpenShamrock',
  docsRepo: 'whitechi73/OpenShamrock',
  docsBranch: 'docs',
  docsDir: 'docs',
  plugins: {
    mdEnhance: {
      // 添加选项卡支持
      tabs: true
    }
  },
  navbar: shamrockNavbar,
  sidebar: shamrockSidebar
})
