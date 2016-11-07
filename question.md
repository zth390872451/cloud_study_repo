Eureka的客户端异常：
RejectedExecutionException: Task java.util.concurrent.FutureTask@1abc4e6 rejected

客户端：
设置激活的默认配置：
先设置为test，
启动成功之后，手动关闭，更改为dev
再次启动，从config server中获取的配置仍然是test配置文件中的信息。
