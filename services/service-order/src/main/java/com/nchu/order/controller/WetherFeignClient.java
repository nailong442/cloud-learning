package com.nchu.order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="whether",url="https://uapis.cn/api/v1/misc")
public interface WetherFeignClient{
    @GetMapping("/weather")
    Object getData(@RequestParam("city") String city);
}
