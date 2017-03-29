import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import VueRouter from 'vue-router'
import store from './vuex/store'
import Vuex from 'vuex'
import NProgress from 'nprogress'//页面顶部进度条
import 'nprogress/nprogress.css'

import Login from './components/Login.vue'
import Home from './components/Home.vue'
import Main from './components/Main.vue'
import Table from './components/nav1/Table.vue'
import Form from './components/nav1/Form.vue'
import Page3 from './components/nav1/Page3.vue'
import Page4 from './components/nav2/Page4.vue'
import Page5 from './components/nav2/Page5.vue'
import Page6 from './components/nav3/Page6.vue'
import Room from './components/room/Room.vue'
import Ping from './components/call/Ping.vue'


Vue.use(ElementUI)
Vue.use(VueRouter)
Vue.use(Vuex)


const routes = [
  { path: '/login', component: Login },
  //{ path: '/main', component: Main },
  {
    path: '/',
    component: Home,
    name: '资源管理',
    children: [
      { path: '/room', component: Room ,name:'机房管理'},
      { path: '/project', component: Table, name: '项目管理' },
      { path: '/server', component: Table, name: '服务器' },
    ]
  },
  {
    path: '/',
    component: Home,
    name: '文件管理',
    children: [
      { path: '/disk', component: Table, name: '文件操作' },
    ]
  },
  {
    path: '/',
    component: Home,
    name: '远程调用',
    children: [
      { path: '/ping', component: Ping, name: '网络诊断' }
    ]
  }
]

const router = new VueRouter({  routes})

router.beforeEach((to, from, next) => {  NProgress.start();  next()})

router.afterEach(transition => {  NProgress.done();});

new Vue({
  el: '#app',
  template: '<App/>',
  router,
  store,
  components: { App }
  //render: h => h(Login)
}).$mount('#app')

router.replace('/room')


