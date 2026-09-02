package com.nchu.order.service;


import com.nchu.common.order.bean.Order;

public interface OrderService {
    Order create(Long userId, Long productId);
}
