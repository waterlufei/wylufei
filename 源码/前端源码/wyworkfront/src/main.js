import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueResource from 'vue-resource'

Vue.use(ElementUI)
Vue.use(VueResource)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  render: h => h(App),
}).$mount('#app')

// router.beforeEach((to, from, next) => {
//   let isLogin = sessionStorage.username;
//   if (to.matched.length === 0) { // 没有匹配到当前路由
//     next('/error')
//   }else if (!isLogin && to.path !== '/user_login') {
//     // 如果没有登录，跳转到登录页面
//     next('/user_login')
  
//   } else {
//       if ((to.path === '/user_login' || to.path === '/error') && isLogin) { 
//         // 如果已经登录，却尝试访问登录页面或者错误页面，将继续保持原本的页面
//         next(from.path)  
//       }else {
//         // 如果已经登录账号buyer
//         if (isLogin === 'buyer'){
//           // 尝试访问seller账号页面时，留在原页面
//           if (to.path === '/edit_goodsInfo' || to.path === '/release_goods' || to.path === '/seller_goodsInfo' || to.path === '/seller_index'){
//             next(from.path)
//           }else{
//             next();
//           }
//         }else{ // 如果已经登录seller账号
//           // 尝试访问seller页面运行
//           if (to.path === '/edit_goodsInfo' || to.path === '/release_goods' || to.path === '/seller_goodsInfo' || to.path === '/seller_index'){
//             next()
//           }else{
//             next(from.path)
//           }
//         }
//       }
//   }
// })


router.beforeEach(function (to, from, next) {
    // 这个全局守卫很坑,1：next('/')需要再次进入beforeEach容易出现无限循环,next()和next(false)不需要，
    // 2：它需要走完整个beforeEach，就算走到了next(false)也还是继续往下走为止走完为止
    const nextRoute = ['edit_goodsInfo','release_goods','seller_goodsInfo','seller_index'];
    let isLogin = sessionStorage.username;
    if (to.matched.length === 0){
      next(false);
    }else if (to.path !== '/user_login' && !isLogin){
        next('/user_login');
    }else if (isLogin){
        if (to.name === 'user_login'){
          next(false); 
        }else if (isLogin ==='buyer'){
          if (nextRoute.indexOf(to.name) >= 0){
            next(false);
          }else{
            next();
          }  
        }else{
          if (nextRoute.indexOf(to.name) >= 0){
            next();
          }else{
            next(false);
          }
        }       
    }else{
      next();
    }
})
