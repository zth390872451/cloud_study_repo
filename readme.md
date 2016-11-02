通常在生产环境，Config Server与服务注册中心一样，我们也需要将其扩展为高可用的集群。
在之前实现的config-server基础上来实现高可用非常简单，不需要我们为这些服务端做任何额外的配置，
只需要遵守一个配置规则：将所有的Config Server都指向同一个Git仓库，这样所有的配置内容就通过
统一的共享文件系统来维护，而客户端在指定Config Server位置时，只要配置Config Server外的均衡负载即可。