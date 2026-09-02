package com.nchu.order.feign;


import com.nchu.common.product.bean.Product;
import com.nchu.order.feign.fallback.ProductFeignClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product",fallback = ProductFeignClientFallBack.class)
public interface ProductFeignClient {
    @GetMapping("/product/{id}")
    public  Product getProduct(@PathVariable("id") Long id);
}
