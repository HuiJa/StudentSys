package org.huija.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 参考使用: https://www.jianshu.com/p/470a30f493cf
     * @return
     */
    @RequestMapping(value="consumer",method = RequestMethod.GET)
    public String hello(){
        return restTemplate.getForObject("http://eureka-provider/actuator/info",String.class, (Object) null);
    }
}
