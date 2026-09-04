package com.nchu.order.service.impl;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nchu.common.cache.NchuCache;
import com.nchu.common.order.bean.Order;
import com.nchu.common.product.bean.Product;
import com.nchu.order.feign.ProductFeignClient;
import com.nchu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductFeignClient productFeignClient;
    @Override
//    @NchuCache(prefix = "order:")
    @SentinelResource(value = "createOrder",blockHandler = "createOrderFallback")
    public Order create(Long userId, Long productId) {
        Order order = new Order();
        order.setUserId(userId);
        Product product = productFeignClient.getProduct(productId);
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setAddress("北京");
        order.setNickname("小白");
        order.setProductList(List.of(product));
        order.setId(1L);
        return order;

    }

    public Order createOrderFallback(Long userId, Long productId, BlockException e){
        Order order = new Order();
        order.setNickname("未知用户");
        return order;
    }


}
