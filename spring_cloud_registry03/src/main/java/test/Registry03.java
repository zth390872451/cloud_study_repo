package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.UnknownHostException;

/**
 * 服务注册中心03
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class Registry03 {
    private static final Logger log = LoggerFactory.getLogger(Registry03.class);

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Registry03.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String contextPath = environment.getProperty("server.context-path");
        String serverPort = environment.getProperty("server.port");
        log.info("Access URLs:127.0.0.1:{}:{}",contextPath,serverPort);
    }
}
