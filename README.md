# toolsDemo
[toc]
toolsDemo 是一个中间件的使用集合，每个module是一个简单的demo。
 * module - mySqlDemo
 * module - jedis

## (mysqlDemo) springboot-mybatis
springboot继承mybatis，实现CURD

### 创建数据库
1。 mac下启动、关闭、重启mysql
https://www.jianshu.com/p/b0cca588f14d

2。 字符集一般选择： utf-8
   排序规则说明，一般选择：utf8_general_ci，校对速度快，但准确度稍差。
   https://blog.csdn.net/weixin_44870139/article/details/112626202
   
3。 参考spring-boot 整合mybatis
   https://blog.csdn.net/iku5200/article/details/82856621
   
4。 最终将代码上传到github
https://blog.csdn.net/qq_40307379/article/details/106251932

## jedis
> 参考狂神说

## swagger
   参考https://blog.csdn.net/hl6164085/article/details/107481231
> swagger是一个用于后台接口生成描述文档或者根据yaml文件生成后台接口的工具集，包括swagger UI进行功能测试、swagger Codegen进行代码生成等组件，这里介绍一下公司最近用到的使用swagger Codegen根据自定义的yaml文件生成对应的后台接口代码。
Swagger包含的工具集：
* Swagger编辑器： Swagger Editor允许您在浏览器中编辑YAML中的OpenAPI规范并实时预览文档。
* Swagger UI： Swagger UI是HTML，Javascript和CSS资产的集合，可以从符合OAS标准的API动态生成漂亮的文档。
* Swagger Codegen：允许根据OpenAPI规范自动生成API客户端库（SDK生成），服务器存根和文档。
* Swagger Parser：用于解析来自Java的OpenAPI定义的独立库
* Swagger Core：与Java相关的库，用于创建，使用和使用OpenAPI定义
* Swagger Inspector（免费）： API测试工具，可让您验证您的API并从现有API生成OpenAPI定义
* SwaggerHub（免费和商业）： API设计和文档，为使用OpenAPI的团队构建。
