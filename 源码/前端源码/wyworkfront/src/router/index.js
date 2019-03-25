import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import buyer_index from '@/pages/buyer_index'
import finance from '@/pages/finance'
import shopping_cart from '@/pages/shopping_cart'
import buyer_no_purchase from '@/pages/buyer_no_purchase'
import seller_index from '@/pages/seller_index'
import user_login from '@/pages/user_login'
import not_purchase_goodsInfo from '@/pages/not_purchase_goodsInfo'
import purchased_goodsInfo from '@/pages/purchased_goodsInfo'
import seller_goodsInfo from '@/pages/seller_goodsInfo'
import edit_goodsInfo from '@/pages/edit_goodsInfo'
import release_goods from '@/pages/release_goods'
import error from '@/pages/error'

Vue.use(Router)

export default new Router({
  // 设置mode会导致全局守卫next()系列函数有问题
  // mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/user_login'
    },
    {
      path: '/Hello',
      name: 'Hello',
      component: HelloWorld
    },
    {
      path: '/buyer_index',
      name: 'buyer_index',
      component: buyer_index
    },
    {
      path: '/finance',
      name: 'finance',
      component: finance
    }, 
    {
      path: '/shopping_cart',
      name: 'shopping_cart',
      component: shopping_cart
    },
    {
      path: '/buyer_no_purchase',
      name: 'buyer_no_purchase',
      component: buyer_no_purchase
    },
    {
      path: '/seller_index',
      name: 'seller_index',
      component: seller_index
    },
    {
      path: '/user_login',
      name: 'user_login',
      component: user_login
    },
    {
      path: '/not_purchase_goodsInfo',
      name: 'not_purchase_goodsInfo',
      component: not_purchase_goodsInfo
    },
    {
      path: '/purchased_goodsInfo',
      name: 'purchased_goodsInfo',
      component: purchased_goodsInfo
    },
    {
      path: '/seller_goodsInfo',
      name: 'seller_goodsInfo',
      component: seller_goodsInfo
    },
    {
      path: '/edit_goodsInfo',
      name: 'edit_goodsInfo',
      component: edit_goodsInfo
    },
    {
      path: '/release_goods',
      name: 'release_goods',
      component: release_goods
    },
    {
      path: '/error',
      name: 'error',
      component: error
    }     
  ]
})
