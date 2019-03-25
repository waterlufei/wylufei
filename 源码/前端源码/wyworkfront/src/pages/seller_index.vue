<template>
  <div style="width:100%">
      <h1>卖家主页</h1>
    <div align="right">
        <el-tag type="info"><router-link to="/release_goods" style="color:#6C6C6C;text-decoration:none">发布</router-link></el-tag>
        <el-tag type="info" style="color:#6C6C6C;cursor:pointer">{{username}}</el-tag>
        <el-tag type="info" @click="logout()" style="color:#6C6C6C;cursor:pointer">退出</el-tag>  
    </div>  
    <div v-for="(n,index) in goodsInfo" :key="index" style="float:left;width:25%">
        <img :src="n.picture" height="333px" @click="jumpGoodsInfo(n.id)" style="cursor:pointer" width="100%"/>
        <p>
          {{n.title}} 
          <span v-if="n.purchaseNumber>0">(已出售{{n.purchaseNumber}}份)</span>
          <span v-else style="color:red" @click="deleteGoods(n.id)">删除</span>
          </p>
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
      username:''
    }    
  },
  created :
  function () {
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
              }else{
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
        deleteGoods: function (dataType) {
            //var vm = this;
            this.$http.post('http://127.0.0.1:9527/goods/deleteGoods?goodsId='+dataType, {
            }).then(function () {
              // for(var i = 0 ;i < res.body.data.length; i++) {
              //    this.goodsInfo = res.body.data;
              // }
              this.$message({
                showClose: true,
                message: '删除信息成功',
                type: 'success'
              }); 
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
        jumpGoodsInfo : function (id){
            this.$router.push({
              name:'seller_goodsInfo',
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