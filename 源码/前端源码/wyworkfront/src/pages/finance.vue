<template>
  <div style="width:100%">
      <h1>财务</h1>
    <div align="right">
        <el-tag type="info"><router-link to="/buyer_index" style="color:#6C6C6C;text-decoration:none">主页</router-link></el-tag>
        <el-tag type="info" style="color:#6C6C6C;cursor:pointer">{{username}}</el-tag>
        <el-tag type="info" @click="logout()" style="color:#6C6C6C;cursor:pointer">退出</el-tag>
        <el-tag type="info"><router-link to="/shopping_cart" style="color:#6C6C6C;text-decoration:none">购物车</router-link></el-tag>
    </div>  
    <div v-for="(n,index) in orderInfo" :key="index" style="float:left;width:25%;margin-bottom:10px;" >
        <p>标题:{{n.title}}</p>
        <img :src="n.picture" height="333px" width="100%" style="cursor:pointer" @click="jumpPurchased(n.id)"/>
        <p>购买时间:{{n.createTime}}</p>
        <p>购买价格:{{n.price}}</p>
        <p>购买数量:{{n.goodsNum}}</p>
    </div>
    <div style="clear:both"></div>
    <div style="margin-top:20px">总金额:{{totalSum}}¥</div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      orderInfo : [],
      totalSum : '',
      username:''
    }    
  },
  created : 
  function (){
      this.username = sessionStorage.username;
      this.getorderInfo();   
  },
  methods: {
      getorderInfo: function () {
            this.$http.post('http://127.0.0.1:9527/order/getOrdersInfo', {
            }).then(function (res) {  
              if (res.body.code != 0){
                this.$message({
                showClose: true,
                message: res.body.msg,
                type: 'success'
                });
              }else{
                this.orderInfo = res.body.data;        
                this.totalSum = res.body.totalSum;
              } 
              }),
              function () {
              this.$notify({
                title: '警告',
                duration: 3000,
                message: '请求失败',
                type: 'warning'
              });
              this.$message({
                showClose: true,
                message: '警告哦，这是一条警告消息',
                type: 'warning'
              });
            }
      },
      logout (){
        sessionStorage.username = '';
        this.$router.push({
            name:'user_login'
            });
      },
      jumpPurchased: function (id){
          this.$router.push({
            name:'purchased_goodsInfo',
            params: {
              goodsId:id
            }
            });
      }
  }
}
</script>


<style scoped>
.el-input {
    width: 200px;
    height: 30px;
}
.el-select #inputContent {
        width: 425px;
        height: 100px;
    }
#cancel {
    margin-left: 100px;
  }
.el-select {
  width: 200px;
  height: 30px;
}
</style>