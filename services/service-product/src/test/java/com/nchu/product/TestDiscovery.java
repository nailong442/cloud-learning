package com.nchu.product;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class TestDiscovery {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private NacosDiscoveryClient nacosDiscoveryClient;

    @Test
    public void test() {
        for (String service : discoveryClient.getServices()) {
            System.out.println(service);
            for (ServiceInstance instance : discoveryClient.getInstances(service)) {
                System.out.println("ip:"+instance.getHost()+"port:"+instance.getPort());
            }
        }
    }

    @Test
    public void test1() {
        for (String service : nacosDiscoveryClient.getServices()) {
            System.out.println(service);
            for (ServiceInstance instance : nacosDiscoveryClient.getInstances(service)) {
                System.out.println("ip:"+instance.getHost()+"port:"+instance.getPort());
            }
        }
    }
}
