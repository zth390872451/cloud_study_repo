package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//配置刷新 请求URL:http://localhost:7002/refresh
public class ComputerController {
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
    private DiscoveryClient client;

    /**
     * curl  http://localhost:8022/add?a=1&b=2
     *
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {

        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        return r;
    }
}