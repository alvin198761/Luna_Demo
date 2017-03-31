# Spring mvc endpoint
> spring mvc 项目 监控，指标解决方案示例

项目没有界面，主要是通过 http://localhost:8090/mvc/data/metrics 等几个url 的方式获取虚拟机相关信息
用于对项目的状态jdk tomcat 等的监控，请求地址以后，会返回一些指标信息，格式可以自定义，我用的json

增加crash 方式获取相关信息