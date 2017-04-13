# Spring mvc endpoint
> spring mvc 项目 监控，指标解决方案示例
仿照spring-boot 做了一个 springmvc的监控终端实现，功能基本可用了

增加crash 方式获取相关信息
通过 putty 或者其他ssh 工具登录，
1. ip ：web 服务所在的ipp
2. port：12345
3. user: admin
4. password: 12345
具体可以在 application.properties 里面修改

输入 help 回车，可以获取具体的命令，
部分命令未能实现，但目前来说已经够用了

日志：
3. 删除了原来通过restful 访问的的指标接口
2. 目前还没有改掉 crash 的welcome 和 prompt ，具体原因未知。有空再修改掉，因为时间关系，暂时不搞了
1. 项目没有界面，主要是通过 http://localhost:8090/mvc/data/metrics 等几个url 的方式获取虚拟机相关信息
用于对项目的状态jdk tomcat 等的监控，请求地址以后，会返回一些指标信息，格式可以自定义，我用的json