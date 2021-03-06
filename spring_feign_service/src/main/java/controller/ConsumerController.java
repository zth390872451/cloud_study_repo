package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ComputeClient;

@RestController
@RefreshScope//配置刷新 请求URL:http://localhost:7002/refresh
public class ConsumerController {
    @Value("${from:test}")
    private String from;
    @Value("${name:name}")
    private String name;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }

    @RequestMapping("/name")
    public String name() {
        return this.name;
    }

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    ComputeClient computeClient;


    /**
     * curl  http://localhost:9020/add
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {

        logger.info("{}", "srping-feigin-service-add2 method");

        return computeClient.add(10, 30);
    }
}

