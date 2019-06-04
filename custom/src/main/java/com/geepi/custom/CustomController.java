package com.geepi.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author liaoyong
 * @date 2019/05/30
 * @since JDK 1.8
 */

@RestController
public class CustomController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;



    @RequestMapping(value = "/router", method = RequestMethod.GET)
    @ResponseBody
    public String route() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("hello-service");
        System.out.println("===" + serviceInstance.getServiceId() + "==" + serviceInstance.getHost() + "==" + serviceInstance.getPort());
        return restTemplate.getForObject("http://hello-service/search/1", String.class);
    }

}
