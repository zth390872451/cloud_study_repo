package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.UnknownHostException;

/**

 */
@EnableConfigServer //作为配置服务：管理git仓库
@EnableDiscoveryClient //自身成为服务，配置多个，提高可用性
@SpringBootApplication
public class ConfigServer01 {
    private static final Logger log = LoggerFactory.getLogger(ConfigServer01.class);
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigServer01.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String contextPath = environment.getProperty("server.context-path");
        String serverPort = environment.getProperty("server.port");
        log.info("Access URLs:127.0.0.1:{}:{}",contextPath,serverPort);
     }
}
