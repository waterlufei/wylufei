<template>
  <div>
      <h1>发布商品</h1>
    <div align="right">
        <el-tag type="info"><router-link to="/seller_index" style="color:#6C6C6C;text-decoration:none">主页</router-link></el-tag>
        <el-tag type="info" style="color:#6C6C6C;cursor:pointer">{{username}}</el-tag>
        <el-tag type="info" @click="logout()" style="color:#6C6C6C;cursor:pointer">退出</el-tag>
    </div>  
    <div>
      <div style="margin:20px">标题:<el-input v-model="inputTitle" placeholder="请输入标题" minlength="2" :maxlength="80"></el-input></div>
      <div style="margin:20px">摘要:<el-input v-model="inputSummary" placeholder="请输入摘要" :maxlength="140"></el-input></div>
      <div style="margin:20px">价格:<el-input v-model="inputPrice" placeholder="请输入价格"></el-input></div>
      <div style="margin:20px">正文:<el-input v-model="inputContent" placeholder="请输入正文" maxlength="1000"></el-input></div>
      <div style="margin:20px">图片:<el-input v-model="inputImage" placeholder="请选取图片文件" :readonly="true"></el-input></div>
      
      <el-upload
          class="upload-demo"
          ref="upload"
          action="http://127.0.0.1:9527/uploadPictures"
          accept="image/jpeg,image/png"
          :on-preview="handlePreview"
          :limit="1"
          :on-exceed="handleExceed"
          :on-change="onUploadChange"
          :auto-upload="false">
          <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          <!-- <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button> -->
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过1M</div>
      </el-upload>
        <div><el-button @click="empty()">取消</el-button><el-button @click="addGoods()">发布</el-button></div>
    </div>
</div>
</template>

<script>
export default {
  data () {
    return {
      goodsInfo : [] ,
      backEndHost:'http://127.0.0.1/images/',
      goodsId:'',
      inputTitle:'',
      inputSummary:'',
      inputImage:'',
      inputPrice:'',
      inputContent:'',
      username:''
    }    
  },
  created :
  function (){
    this.username = sessionStorage.username;
  },
  methods: {  
      addGoods: function () {
            this.$http.post('http://127.0.0.1:9527/goods/increaseGoods', {
              "title":this.inputTitle,
              "summary":this.inputSummary,
              "content":this.inputContent,
              "price":this.inputPrice,
              "picture":this.inputImage
            }).then(function (res) {
              this.$refs.upload.submit();      
              this.$message({
                showClose: true,
                message: res.body.msg,
                type: 'success'
              }); 
              this.$router.push({
              name:'seller_goodsInfo',
              params: {
                goodsId:res.body.data.goodsId
              }
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
      empty: function (){
          this.inputTitle="",
          this.inputSummary="",
          this.inputImage="",
          this.inputPrice="",
          this.inputContent=""
      },
      submitUpload(){
          this.$refs.upload.submit();
      },
      onUploadChange(file)
      {
        const isIMAGE = (file.raw.type === 'image/jpeg' || file.raw.type === 'image/png');
        const isLt1M = file.size / 1024 / 1024 < 1;

        if (!isIMAGE) {
          this.$message.error('只能上传jpg/png图片!');
          return false;
        }
        if (!isLt1M) {
          this.$message.error('上传文件大小不能超过 1MB!');
          return false;
        }
        this.inputImage = this.backEndHost + file.name;
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
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
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>