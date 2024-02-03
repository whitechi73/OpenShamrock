import { sidebar } from 'vuepress-theme-hope'

const children = {
  guide: ['getting-started', 'configuration', 'faq'],
  advanced: ['voice'],
  api: [
    'request-response',
    'account',
    'contact',
    'user',
    'message',
    'resources',
    'dispose',
    'group',
    'file',
    'shamrock',
    'other'
  ],
  message: ['format', 'normal', 'media', 'special', 'advanced'],
  event: ['general-data', 'message', 'notice', 'request']
}

const shamrockSidebar = sidebar([
  {
    text: '指南',
    prefix: 'guide',
    icon: 'lightbulb',
    collapsible: true,
    children: children.guide
  },
  {
    text: '进阶',
    prefix: 'advanced',
    icon: 'gem',
    collapsible: true,
    children: children.advanced
  },
  {
    text: '接口',
    prefix: 'api',
    icon: 'laptop-code',
    collapsible: true,
    children: children.api
  },
  {
    text: '消息',
    prefix: 'message',
    icon: 'comment',
    collapsible: true,
    children: children.message
  },
  {
    text: '事件',
    prefix: 'event',
    icon: 'bell',
    collapsible: true,
    children: children.event
  }
])

export { shamrockSidebar }
