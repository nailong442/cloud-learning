package com.nchu.product.service;


import com.nchu.common.product.bean.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("10"));
        product.setProductName("product");
        product.setNum(2);
//        System.out.println(1/0);
        return product;
    }
}
