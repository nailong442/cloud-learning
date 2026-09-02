package com.nchu.order.feign.fallback;


import com.nchu.common.product.bean.Product;
import com.nchu.order.feign.ProductFeignClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductFeignClientFallBack implements ProductFeignClient {
    @Override
    public Product getProduct(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setProductName("默认数据");
        product.setNum(0);
        product.setPrice(new BigDecimal(0));
        System.out.println("兜底回调");
        return product;
    }
}
