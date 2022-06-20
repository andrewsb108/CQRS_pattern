package com.codebuffer.ProductService.command.api.event;

import com.codebuffer.ProductService.command.api.data.Product;
import com.codebuffer.ProductService.command.api.data.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ProcessingGroup("product")
public class ProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(event, product);
        productRepository.save(product);
        throw new Exception("Exception Occurred");
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
