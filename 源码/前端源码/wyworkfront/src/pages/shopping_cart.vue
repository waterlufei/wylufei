<template>
  <div>
      <h1>购物车</h1>
    <div align="right">
        <el-tag type="info"><router-link to="/buyer_index" style="color:#6C6C6C;text-decoration:none">主页</router-link></el-tag>
        <el-tag type="info" style="color:#6C6C6C;cursor:pointer">{{username}}</el-tag>
        <el-tag type="info" @click="logout()" style="color:#6C6C6C;cursor:pointer">退出</el-tag>
        <el-tag type="info"><router-link to="/finance" style="color:#6C6C6C;text-decoration:none">财务</router-link></el-tag>
        <el-tag type="info"><router-link to="/shopping_cart" style="color:#6C6C6C;text-decoration:none">购物车</router-link></el-tag>
    </div> 
    <div style="text-align: center">
    <el-table
      :data="tableData"
      style="width: 50%;margin:auto">
      <el-table-column
        prop="title"
        label="标题"
        width="180">
      </el-table-column>
      <el-table-column
        prop="price"
        label="价格"
        width="180">
      </el-table-column>
      <el-table-column
        prop="goodsNum"
        label="数量">
      </el-table-column>
    </el-table>
    </div> 
    <el-button  @click="$router.back(-1)">退出</el-button><el-button @click="emptyCart()">购买</el-button>
  </div>
</template>
<script>
export default {
  data (){
    return{
      tableData:[],
      username:''
    }
  },
  created:
  function (){
    this.username = sessionStorage.username;
    this.getShoppingCartAllInfo();
  },
  methods:{
     getShoppingCartAllInfo: function () {
            this.$http.post('http://127.0.0.1:9527/shoppingCart/getShoppingCartAllInfo', {
            }).then(function (res) {
              if (res.body.code != 0){
                this.$message({
                showClose: true,
                message: res.body.msg,
                type: 'success'
              });
              }else{
                this.tableData = res.body.data;
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
      emptyCart: function () {
            this.$http.post('http://127.0.0.1:9527/order/addOrder', {
            }).then(function (res) {
              this.tableData=[];
              this.$message({
                showClose: true,
                message: res.body.msg,
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