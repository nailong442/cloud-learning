package com.nchu.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.common.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       String resourceName,
                       BlockException e) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(Result.error(500,"被限流了"+e.getClass())));
    }
}
