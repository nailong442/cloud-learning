package com.nchu.order.controller;


import com.nchu.common.order.bean.Order;
import com.nchu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private WetherFeignClient wetherFeignClient;

    @Value("${order.name}")
    String name;

    @Value("${order.age}")
    int age;

    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        return orderService.create(userId,productId);
    }


    @GetMapping("/config")
    public String config() {
        return "name:"+name+",age:"+age;
    }

    @GetMapping("/weather")
    public Object getCityWether(@RequestParam("city")String city) {
        return wetherFeignClient.getData(city);
    }

}
