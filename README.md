# wylufei
## 项目分为源码和生产环境文件两大块，直接看结果推荐使用生成环境文件，也可以在编辑器中打开源码运行看效果
## 1、源码：
### 1.1、后端源码spring boot2版本,推荐使用idea打开，
### 1.2、前端源码是vue2.x版本，推荐使用vscode，打开console窗口使用，npm install或cnpm install，然后使用npm run serve命令运行
### 1.3、图片存储服务器考虑到实现图片的实时上传刷新，使用了一个nginx，上传的图片存储在html/images/下，windows双击nginx.exe启动运行，nginx需要在全英文目录
## 2、生产环境文件：
### 2.1、后端是一个jar包，使用java -jar WyWork-0.0.1-SNAPSHOT.jar命令运行
### 2.2、前端模块是生成的静态文件直接双击index.html启动
### 2.3、图片存储服务器源码中的nginx一样
