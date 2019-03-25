<template>
  <div style="width:100%">
      <h1>买家主页</h1>
    <div align="right">
        <el-tag type="info"><router-link to="/buyer_no_purchase" style="color:#6C6C6C;text-decoration:none">未购买内容</router-link></el-tag>
        <el-tag type="info" style="color:#6C6C6C;cursor:pointer">{{username}}</el-tag>
        <el-tag type="info" @click="logout()" style="color:#6C6C6C;cursor:pointer">退出</el-tag>
        <el-tag type="info"><router-link to="/finance" style="color:#6C6C6C;text-decoration:none">财务</router-link></el-tag>
        <el-tag type="info"><router-link to="/shopping_cart" style="color:#6C6C6C;text-decoration:none">购物车</router-link></el-tag>
    </div>  
    <div v-for="(n,index) in goodsInfo" :key="index" style="float:left;width:25%;">
        <span v-if="n.purchaseNumber>0">
          <img :src="n.picture" height="333px" @click="jumpPurchased(n.id)" style="cursor:pointer" width="100%"/>
        </span>
        <span v-else>
          <img :src="n.picture" height="333px" @click="jumpNotPurchase(n.id)" style="cursor:pointer" width="100%"/>
        </span>
        <p>
          {{n.title}} <span v-if="n.purchaseNumber>0">(已购买)</span></p>
        <p>价格:¥{{n.price}}</p>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      goodsInfo : [] ,
      error : '',
      backEndHost:'http://127.0.0.1:9527/',
      username: ''
    }    
  },
  events:{
    getGoodsInfo: function () {
    }
  },
  created : 
  function (){
      this.username = sessionStorage.username;
      this.getGoodsInfo();   
  },
  methods: {
      getGoodsInfo: function () {
            this.$http.post('http://127.0.0.1:9527/goods/getGoodsInfo', {
            }).then(function (res) {
              if (res.body.code != 0){
                this.$message({
                showClose: true,
                message: res.body.msg,
                type: 'success'
                }); 
              }
              if (res.body.code == 0){
                this.goodsInfo = res.body.data;  
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
      jumpNotPurchase: function (id){
          this.$router.push({
            name:'not_purchase_goodsInfo',
            params: {
              goodsId:id
            }
            });
      },
      jumpPurchased: function (id){
          this.$router.push({
            name:'purchased_goodsInfo',
            params: {
              goodsId:id
            }
            });
      },
      logout (){
        sessionStorage.username = '';
        this.$router.push({
            name:'user_login'
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