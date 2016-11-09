package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import service.ConsumerService;

/**
 * Created by Administrator on 2016/11/9.
 */
@RestController
@RefreshScope//配置刷新 请求URL:http://localhost:7002/refresh
public class RibbonConsumerController {

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

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ConsumerService consumerService;

    /**
     * 无断路器
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    /**
     * 有断路器
     * @return
     */
    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public String add2() {
        return consumerService.addService();
    }

}
