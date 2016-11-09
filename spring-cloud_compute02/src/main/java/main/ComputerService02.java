package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2016/11/9.
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(value = "controller,service")
public class ComputerService02 {
    public static void main(String[] args) throws Exception {
        //开启监控 http://localhost:8080/health
        SpringApplication.run(ComputerService02.class, args);

    }
}
