
<template>
  <div style="margin:auto">
    <h1>网易文漫欢迎登录</h1>
    <div>
      <div style="margin:20px"><el-input v-model="username" placeholder="请输入用户名"></el-input></div>
      <div style="margin:20px"><el-input placeholder="请输入密码" v-model="password" type="password" @keyup.enter.native="checkLogin()"></el-input></div>
      <el-button @click="empty()">取消</el-button><el-button @click="checkLogin()">登录</el-button>
    </div>
  </div>
</template>

<script>
import md5 from 'js-md5'
export default {
  data () {
    return {
      username:'',
      password:'',
      userInfo:""
    }    
  },
  methods: {
      checkLogin: function () {
            this.$http.post('http://127.0.0.1:9527/user/logIn', {
                "username" : this.username,
                "password" : md5(this.password)
            }).then(function (res) {
              if (res.body.code != 0){
                  this.$message({
                    showClose: true,
                    message: res.body.msg,
                    type: 'success'
                  }); 
              } 
              if (res.body.code == 0){
                this.userInfo = res.body.data;   
                sessionStorage.username = this.userInfo.username;
                if (this.userInfo.username == 'buyer'){               
                    this.$router.push({name:'buyer_index'});
                }else{
                    this.$router.push({name:'seller_index'});
                }
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
        empty(){
          this.username = '';
          this.password = '';
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