#Jersey-mybayis-mysql-demo

##环境
- JDK 8
- MySQL
- Gradle


##初始化数据库

将`src/main/resources/config.properties` 中的 `password`的值修改成你自己的`mysql root`的密码。

然后执行：

```shell
$ cd mybatis-demo
$ ./db-initial.sh(需要输入mysql root密码)
```

>提示：Mac下如果执行`./db-initial.sh`报错，尝试使用`. db-initial.sh`

看到如下输出，表示数据库初始化成功

```shell
id name   gender
1  Bulma  female
2  Vegeta male
3  ChiChi female
4  Goku   male
```


##运行demo
```
$ cd Jersey-mybayis-mysql-demo
$ gradle build
$ gradle jettyRun
```


此时，在控制台下应该可以看到类似如下的输出： 
```shell
:prepareInplaceWebAppFolder UP-TO-DATE
:createInplaceWebAppFolder UP-TO-DATE
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:prepareInplaceWebAppClasses UP-TO-DATE
:prepareInplaceWebApp UP-TO-DATE
:jettyRun
ERROR StatusLogger No log4j2 configuration file found. Using default configuration: logging only errors to the console.
15:46:05 INFO  Jetty 9.2.15.v20160210 started and listening on port 8080
15:46:05 INFO  jersey-mybatis-mysql-demo runs at:
15:46:05 INFO    http://localhost:8080/jersey-mybatis-mysql-demo
Press any key to stop the server.
$ Building 87% > :jettyRun
```

## 在浏览器中验证结果
### 获取指定用户信息
打开浏览器，输入 `http://localhost:8080/Jersey-mybayis-mysql-demo/users/1`  
将看到页面打印出 `{"id":1,"name":"Bulma","gender":"female"}`  
改变 URL 中的 `1` 为其他数字，可以看到打印用户信息随之改变 :)  

### 获取所有用户信息
打开浏览器，输入 `http://localhost:8080/Jersey-mybayis-mysql-demo/users`  
将看到页面打印出四个用户的信息
```javascript
[{"id":1,"name":"Bulma","gender":"female"},
{"id":2,"name":"Vegeta","gender":"male"},
{"id":3,"name":"ChiChi","gender":"female"},
{"id":4,"name":"Goku","gender":"male"}]`
```

