<template>
  <div>
      <h1>商品详细信息</h1>
    <div align="right">
        <el-tag type="info"><router-link to="/seller_index" style="color:#6C6C6C;text-decoration:none">主页</router-link></el-tag>
        <el-tag type="info" style="color:#6C6C6C;cursor:pointer">{{username}}</el-tag>
        <el-tag type="info" @click="logout()" style="color:#6C6C6C;cursor:pointer">退出</el-tag>
    </div>  
    <div>
        <div style="margin:20px">标题:<el-input v-model="notPurchaseGoodsInfo.title" placeholder="请输入标题" :readonly="true"></el-input></div>
        <div style="margin:20px">摘要:<el-input v-model="notPurchaseGoodsInfo.summary" placeholder="请输入摘要" :readonly="true"></el-input></div>
        <div style="margin:20px">价格:<el-input v-model="notPurchaseGoodsInfo.price" placeholder="请输入价格" :readonly="true"></el-input></div>
        <div style="margin:20px">正文:<el-input v-model="notPurchaseGoodsInfo.content" placeholder="请输入正文" :readonly="true"></el-input></div>
        <div><el-button @click="jumpSellerIndex()">取消</el-button><el-button @click="jumpEditGoodsInfo()">编辑</el-button></div>
    </div>
</div>
</template>

<script>
export default {
  data () {
    return {
      notPurchaseGoodsInfo:"" ,
      error : '',
      backEndHost:'D:\\down\\images',
      goodsId: '',
      dialogVisible: false,
      username:''
    }    
  },
  mounted : function(){
            this.username = sessionStorage.username;
            this.goodsId = this.$route.params.goodsId;
            this.getGoodsInfoByGoodsId(this.goodsId);
        },
  methods: {
      getGoodsInfoByGoodsId: function (dataType) {
            this.$http.post('http://127.0.0.1:9527/goods/getGoodsInfoByGoodsId?goodsId=' + dataType, {
            }).then(function (res) {
              if (res.body.code != 0){
                this.$message({
                  showClose: true,
                  message: res.body.msg,
                  type: 'success'
                }); 
              }else{
                this.notPurchaseGoodsInfo = res.body.data;
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
        jumpEditGoodsInfo: function (){
          this.$router.push({
            name:'edit_goodsInfo',
            params: {
              goodsId:this.notPurchaseGoodsInfo.id,
              title:this.notPurchaseGoodsInfo.title,
              summary:this.notPurchaseGoodsInfo.summary,
              picture:this.notPurchaseGoodsInfo.picture,
              price:this.notPurchaseGoodsInfo.price,
              content:this.notPurchaseGoodsInfo.content
            }
            });
        },
        jumpSellerIndex (){
          this.$router.push({
            name:'seller_index'
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