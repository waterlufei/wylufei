<template>
  <div>
      <h1>未购买商品明细</h1>
    <div align="right">
        <el-tag type="info"><router-link to="/buyer_index" style="color:#6C6C6C;text-decoration:none">主页</router-link></el-tag>
        <el-tag type="info" style="color:#6C6C6C;cursor:pointer">{{username}}</el-tag>
        <el-tag type="info" @click="logout()" style="color:#6C6C6C;cursor:pointer">退出</el-tag>
        <el-tag type="info"><router-link to="/finance" style="color:#6C6C6C;text-decoration:none">财务</router-link></el-tag>
        <el-tag type="info"><router-link to="/shopping_cart" style="color:#6C6C6C;text-decoration:none">购物车</router-link></el-tag>
    </div>  
    <div>
        <div style="margin:20px">标题:<el-input v-model="notPurchaseGoodsInfo.title" placeholder="标题" :readonly="true"></el-input></div>
        <div style="margin:20px">摘要:<el-input v-model="notPurchaseGoodsInfo.summary" placeholder="摘要" :readonly="true"></el-input></div>
        <div style="margin:20px">价格:<el-input v-model="notPurchaseGoodsInfo.price" placeholder="价格" :readonly="true"></el-input></div>
        <div style="margin:20px">正文:<el-input v-model="notPurchaseGoodsInfo.content" placeholder="正文" :readonly="true"></el-input></div>
        <!-- <div><el-button @click="jumpSellerIndex()">取消</el-button><el-button @click="jumpEditGoodsInfo()">编辑</el-button></div> -->
        <!-- 商品id:{{goodsId}}<br/> -->
        <div>
        <el-button @click="jumpBuyerIndex()">取消</el-button>
        <el-button @click="dialogVisible=true">购买</el-button>
        <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
          <span>确定将商品{{notPurchaseGoodsInfo.title}}加入购物车吗？</span>
          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="addShoppingCart()">确 定</el-button>
          </span>
        </el-dialog>
        </div>
    </div>
</div>
</template>

<script>
export default {
  data () {
    return {
      notPurchaseGoodsInfo:"" ,
      error : '',
      backEndHost:'http://127.0.0.1:9527/',
      goodsId: '',
      dialogVisible: false,
      username:''
    }    
  },
  created :
  function () {
    this.username = sessionStorage.username;
  },
  mounted : function(){
            
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
                  message: '获得买家未购买内容成功',
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
        handleClose: function() {
        this.$confirm('确认购买？').then(function (){
            this.addShoppingCart();
          })
          .catch({});
        },
        addShoppingCart: function () {
            this.$http.post('http://127.0.0.1:9527/shoppingCart/addShoppingCart', {
                "goodsId":this.goodsId
            }).then(function (res) {
              this.dialogVisible = false;
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
        },
        jumpBuyerIndex (){
          this.$router.push({
            name:'buyer_index'
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