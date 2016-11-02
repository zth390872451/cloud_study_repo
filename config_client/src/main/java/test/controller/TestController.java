package test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope//配置刷新 请求URL:http://localhost:7002/refresh
@RestController
public class TestController {

    @Value("${from:test}")
    private String from;
    @RequestMapping("/from")
    public String from() {
        return this.from;
    }

}
